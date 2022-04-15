//package com.ddimidyuk.moviespace.webclient.config
//
//import com.github.benmanes.caffeine.cache.Caffeine
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.cache.CacheManager
//import org.springframework.cache.annotation.EnableCaching
//import org.springframework.cache.caffeine.CaffeineCacheManager
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.context.annotation.Profile
//import java.net.http.HttpClient
//import java.net.http.HttpRequest
//import java.util.concurrent.TimeUnit
//
//@Configuration
//class HttpClientConfig(
//        @Value("\${cache.max-size}") val cacheMaxSize: Long,
//        @Value("\${cache.expire-time-hours}") val expireTimeHours: Long,
//) {
//
//    @Bean
//    fun httpClient(): HttpClient {
//        HttpRequest.newBuilder().
//        val client = HttpClient.newBuilder()
//            .connectTimeout()
//            .authenticator(A)
//    }`
//}