package com.ddimidyuk.moviespace.movie

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MovieController(
        private val service: MovieService
) {

    @GetMapping("/movie/{movieId}")
    fun getMovie(
            @PathVariable(required = true) movieId: String,
            @RequestParam(required = true) language: String
    ) = service.getMovie(movieId, language)

}