package com.ysmjjsy.goya.framework.cache;

import com.ysmjjsy.goya.core.cache.ICache;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import java.time.Duration;
import java.util.concurrent.Callable;

/**
 * <p></p>
 *
 * @author goya
 * @since 2026/1/12 22:22
 */
@Slf4j
@RequiredArgsConstructor
public class GoyaCaffeineCache implements ICache<Object, Object>, Cache {

    /**
     * 缓存名称
     */
    private final String name;

    /**
     * Caffeine Cache 实例
     */
    private final com.github.benmanes.caffeine.cache.Cache<Object, Object> cache;

    @Override
    @NullMarked
    public String getName() {
        return name;
    }

    @Override
    @NullMarked
    public Object getNativeCache() {
        return cache;
    }

    @Override
    @NullMarked
    public @Nullable ValueWrapper get(Object key) {
        Object value = cache.getIfPresent(key);
        if (value instanceof CaffeineExpiringValue ev) {
            return new SimpleValueWrapper(ev.value());
        }
        return value != null ? new SimpleValueWrapper(value) : null;
    }

    @Override
    @NullMarked
    public @Nullable <T> T get(Object key, @Nullable Class<T> type) {
        Object value = cache.getIfPresent(key);

        if (value instanceof CaffeineExpiringValue ev) {
            value = ev.value();
        }

        if (value == null) {
            return null;
        }

        if (type == null) {
            @SuppressWarnings("unchecked")
            T result = (T) value;
            return result;
        }

        if (!type.isInstance(value)) {
            throw new IllegalStateException(
                    "Cached value is not of required type [" + type.getName() + "]: " + value
            );
        }

        return type.cast(value);
    }

    @Override
    @NullMarked
    public @Nullable <T> T get(Object key, Callable<T> valueLoader) {
        try {
            @SuppressWarnings("unchecked")
            Object value = cache.get(key, k -> {
                try {
                    return valueLoader.call();
                } catch (Exception e) {
                    throw new Cache.ValueRetrievalException(key, valueLoader, e);
                }
            });

            if (value instanceof CaffeineExpiringValue ev) {
                return (T) ev.value();
            }
            return (T) value;

        } catch (RuntimeException ex) {
            if (ex.getCause() instanceof Cache.ValueRetrievalException vre) {
                throw vre;
            }
            throw ex;
        }
    }

    @Override
    @NullMarked
    public void put(Object key, @Nullable Object value) {
        if (value == null) {
            cache.invalidate(key);
        } else {
            cache.put(key, value);
        }
    }

    @Override
    public void put(Object key, @Nullable Object value, Duration ttl) {
        if (value == null) {
            cache.invalidate(key);
        } else {
            cache.put(key, new CaffeineExpiringValue(value, ttl));
        }
    }

    @Override
    public void delete(Object key) {
        this.evict(key);
    }

    @Override
    public boolean exists(Object key) {
        return this.get(key) != null;
    }

    @Override
    @NullMarked
    public void evict(Object key) {
        cache.invalidate(key);
    }

    @Override
    public void clear() {
        cache.invalidateAll();
    }
}
