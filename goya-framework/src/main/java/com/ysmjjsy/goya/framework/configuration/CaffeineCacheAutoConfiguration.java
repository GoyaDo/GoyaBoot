package com.ysmjjsy.goya.framework.configuration;

import com.ysmjjsy.goya.core.cache.CacheService;
import com.ysmjjsy.goya.framework.cache.CaffeineCacheService;
import com.ysmjjsy.goya.framework.cache.GoyaCaffeineCacheManager;
import com.ysmjjsy.goya.framework.cache.properties.CaffeineCacheProperties;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;

/**
 * <p></p>
 *
 * @author goya
 * @since 2026/1/12 23:07
 */
@Slf4j
@AutoConfiguration
@EnableCaching
@EnableConfigurationProperties(CaffeineCacheProperties.class)
public class CaffeineCacheAutoConfiguration {

    @PostConstruct
    public void init() {
        log.debug("[Goya] |- framework [framework] CaffeineCacheAutoConfiguration auto configure.");
    }

    @Bean
    public CaffeineCacheManager caffeineCacheManager(CaffeineCacheProperties caffeineCacheProperties) {
        GoyaCaffeineCacheManager localEventPublisher = new GoyaCaffeineCacheManager(caffeineCacheProperties);
        log.trace("[Goya] |- framework [framework] CaffeineCacheAutoConfiguration |- bean [caffeineCacheManager] register.");
        return localEventPublisher;
    }

    @Bean
    public CacheService caffeineCacheService(CaffeineCacheManager caffeineCacheManager) {
        CaffeineCacheService localEventPublisher = new CaffeineCacheService(caffeineCacheManager);
        log.trace("[Goya] |- framework [framework] CaffeineCacheAutoConfiguration |- bean [caffeineCacheService] register.");
        return localEventPublisher;
    }
}
