package com.ddimidyuk.moviespace.movie

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("movie")
class MovieController(
        private val service: MovieService
) {

    @GetMapping("/{id}")
    fun getMovie(
            @PathVariable(required = true) id: String,
            @RequestParam(required = true) language: String
    ) = service.getMovieInfo(id, language)

}