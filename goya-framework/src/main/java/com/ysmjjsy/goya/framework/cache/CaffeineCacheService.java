package com.ysmjjsy.goya.framework.cache;

import com.ysmjjsy.goya.core.cache.CacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.caffeine.CaffeineCacheManager;

import java.time.Duration;

/**
 * <p></p>
 *
 * @author goya
 * @since 2026/1/12 22:54
 */
@Slf4j
@RequiredArgsConstructor
public class CaffeineCacheService implements CacheService {

    private final CaffeineCacheManager caffeineCacheManager;

    @Override
    public <K, V> V get(String cacheName, K key) {
        Cache cache = caffeineCacheManager.getCache(cacheName);
        if (cache == null) {
            return null;
        }

        Cache.ValueWrapper wrapper = cache.get(key);
        if (wrapper == null) {
            return null;
        }

        @SuppressWarnings("unchecked")
        V value = (V) wrapper.get();
        return value;
    }

    @Override
    public <K, V> void put(String cacheName, K key, V value) {
        Cache cache = caffeineCacheManager.getCache(cacheName);
        if (cache == null) {
            log.warn("Cache [{}] not found, skip put", cacheName);
            return;
        }
        cache.put(key, value);
    }

    @Override
    public <K, V> void put(String cacheName, K key, V value, Duration ttl) {
        Cache cache = caffeineCacheManager.getCache(cacheName);
        if (cache == null) {
            log.warn("Cache [{}] not found, skip put with ttl", cacheName);
            return;
        }

        if (cache instanceof GoyaCaffeineCache caffeineCache) {
            caffeineCache.put(key, value, ttl);
        } else {
            // 兜底：不支持 TTL 的 Cache 实现
            cache.put(key, value);
            log.debug("Cache [{}] does not support per-entry ttl, fallback to normal put", cacheName);
        }
    }

    @Override
    public <K> void delete(String cacheName, K key) {
        Cache cache = caffeineCacheManager.getCache(cacheName);
        if (cache == null) {
            return;
        }
        cache.evict(key);
    }

    @Override
    public <K> boolean exists(String cacheName, K key) {
        Cache cache = caffeineCacheManager.getCache(cacheName);
        if (cache == null) {
            return false;
        }
        return cache.get(key) != null;
    }
}
