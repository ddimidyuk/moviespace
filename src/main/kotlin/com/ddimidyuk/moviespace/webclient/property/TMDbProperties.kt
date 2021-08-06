package com.ddimidyuk.moviespace.webclient.property

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "tmdb")
data class TMDbProperties(
        var baseUrl: String = "",
        var apiKey: String = ""
)