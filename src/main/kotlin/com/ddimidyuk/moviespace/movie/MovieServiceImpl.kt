package com.ddimidyuk.moviespace.movie

import com.ddimidyuk.moviespace.webclient.TMDbWebClient
import com.ddimidyuk.moviespace.webclient.dto.MovieDTO
import org.apache.logging.log4j.kotlin.logger
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class MovieServiceImpl(private val tmdbWebClient: TMDbWebClient): MovieService {

    val logger = logger()

    @Cacheable("movies")
    override fun getMovieInfo(id: String, language: String): MovieDTO {
        logger.debug { "TMDb movie info id=$id request..." }
        return tmdbWebClient.getMovieInfo(id, language) ?: throw NullPointerException()
    }

}