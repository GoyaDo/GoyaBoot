package com.ysmjjsy.goya.framework.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Expiry;
import com.github.benmanes.caffeine.cache.RemovalCause;
import com.ysmjjsy.goya.framework.cache.properties.CaffeineCacheProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NullMarked;
import org.springframework.cache.caffeine.CaffeineCacheManager;

import java.time.Duration;
import java.util.Objects;

/**
 * <p></p>
 *
 * @author goya
 * @since 2026/1/12 22:34
 */
@Slf4j
@RequiredArgsConstructor
public class GoyaCaffeineCacheManager extends CaffeineCacheManager {

    private final CaffeineCacheProperties caffeineCacheProperties;

    @Override
    @NullMarked
    protected Cache<Object, Object> createNativeCaffeineCache(String name) {
        return Caffeine.newBuilder()
                .expireAfter(new Expiry<>() {

                    @Override
                    public long expireAfterCreate(
                            Object key, Object value, long currentTime) {

                        if (value instanceof CaffeineExpiringValue ev) {
                            Duration ttl = ev.ttl();
                            if (Objects.isNull(ttl)) {
                                return caffeineCacheProperties.defaultTtl().toNanos();
                            }
                            return ttl.toNanos();
                        }
                        // 默认 TTL（兜底）
                        return caffeineCacheProperties.defaultTtl().toNanos();
                    }

                    @Override
                    public long expireAfterUpdate(
                            Object key, Object value,
                            long currentTime, long currentDuration) {
                        return currentDuration;
                    }

                    @Override
                    public long expireAfterRead(
                            Object key, Object value,
                            long currentTime, long currentDuration) {
                        return currentDuration;
                    }
                })
                .maximumSize(caffeineCacheProperties.maximumSize())
                .recordStats()
                .removalListener((Object key, Object value, RemovalCause cause) -> log.isDebugEnabled())
                .build();
    }

    @Override
    @NullMarked
    protected org.springframework.cache.Cache createCaffeineCache(String name) {
        return new GoyaCaffeineCache(name, createNativeCaffeineCache(name));
    }
}
