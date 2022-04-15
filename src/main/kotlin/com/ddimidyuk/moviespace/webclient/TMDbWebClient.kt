package com.ddimidyuk.moviespace.webclient

import com.ddimidyuk.moviespace.webclient.dto.MovieDTO
import com.ddimidyuk.moviespace.webclient.property.TMDbProperties
import org.springframework.stereotype.Component

@Component
class TMDbWebClient(
//        private val httpClient HttpClient,
        private val tmdbProperties: TMDbProperties) {

//    private val webClient: WebClient = WebClient.builder()
//            .baseUrl(tmdbProperties.baseUrl)
//            .build()

    fun getMovieInfo(id: String, language: String): MovieDTO? = null
//            webClient.get()
//            .uri("/movie/$id") { uriBuilder ->
//                uriBuilder
//                        .queryParam("api_key", tmdbProperties.apiKey)
//                        .queryParam("language", language)
//                        .build()
//            }
//            .retrieve()
//            .bodyToMono(MovieDTO::class.java)
//            .block() ?: throw RuntimeException()

}