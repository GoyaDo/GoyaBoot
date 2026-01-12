package com.ysmjjsy.goya.framework.cache.properties;

import com.ysmjjsy.goya.framework.constants.PropertyConst;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.Duration;

/**
 * <p></p>
 *
 * @author goya
 * @since 2026/1/12 23:05
 */
@ConfigurationProperties(PropertyConst.PROPERTY_CAFFEINE)
public record CaffeineCacheProperties(

        @Schema(description = "默认过期时间")
        @DefaultValue("PT5M")
        Duration defaultTtl,

        @Schema(description = "最大容量")
        @DefaultValue("100000")
        Long maximumSize
) {
}
