package com.ddimidyuk.moviespace.cache

import com.github.benmanes.caffeine.cache.Caffeine
import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.caffeine.CaffeineCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import java.util.concurrent.TimeUnit

@Profile("caffeine")
@Configuration
@EnableCaching
class CaffeineCacheConfig(
        @Value("\${cache.max-size}") val cacheMaxSize: Long,
        @Value("\${cache.expire-time-hours}") val expireTimeHours: Long,
) {

    @Bean
    fun caffeineConfig(): Caffeine<Any, Any> {
        return Caffeine.newBuilder()
                .maximumSize(cacheMaxSize)
                .expireAfterWrite(expireTimeHours, TimeUnit.HOURS)
    }

    @Bean
    fun cacheManager(caffeine: Caffeine<Any, Any>): CacheManager? {
        val caffeineCacheManager = CaffeineCacheManager()
        caffeineCacheManager.setCaffeine(caffeine)
        return caffeineCacheManager
    }
}