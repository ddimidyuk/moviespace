package com.ddimidyuk.moviespace.movie

import com.ddimidyuk.moviespace.webclient.TMDbWebClient
import org.springframework.stereotype.Service

@Service
class MovieService(private val tmdbWebClient: TMDbWebClient) {

    fun getMovie(id: String, language: String) = tmdbWebClient.getMovie(id, language)

}