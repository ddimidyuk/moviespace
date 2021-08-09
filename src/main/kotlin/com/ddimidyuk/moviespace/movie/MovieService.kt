package com.ddimidyuk.moviespace.movie

import com.ddimidyuk.moviespace.webclient.dto.MovieDTO

interface MovieService {

    /**
     * Returns a movie info.
     *
     * @param  id  TMDB movie id
     * @param  language TMDb language param
     * @return      the movie info
     */
    fun getMovieInfo(id: String, language: String): MovieDTO

}