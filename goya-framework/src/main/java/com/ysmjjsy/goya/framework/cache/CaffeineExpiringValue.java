package com.ysmjjsy.goya.framework.cache;

import java.io.Serial;
import java.io.Serializable;
import java.time.Duration;

/**
 * <p></p>
 *
 * @author goya
 * @since 2026/1/12 22:40
 */
public record CaffeineExpiringValue(Object value, Duration ttl) implements Serializable {

    @Serial
    private static final long serialVersionUID = 8140505030189847474L;
}
