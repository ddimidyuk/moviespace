package com.ddimidyuk.moviespace.webclient.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class MovieDTO(
        val adult: Boolean?,
        val backdropPath: String?,
        val belongsToCollection: MovieBelongsToCollectionDTO?,
        val budget: Int?,
        val genres: List<GenreDTO>?,
        val homepage: String?,
        val id: Int?,
        val imdbId: String?,
        val originalLanguage: String?,
        val originalTitle: String?,
        val overview: String?,
        val popularity: Double?,
        val posterPath: String?,
        val productionCompanies: List<ProductionCompanyDTO>?,
        val productionCountries: List<ProductionCountryDTO>?,
        val releaseDate: String?,
        val revenue: Int?,
        val runtime: Int?,
        val spokenLanguages: List<LanguageDTO>?,
        val status: String?,
        val tagline: String?,
        val title: String?,
        val video: Boolean?,
        val voteAverage: Double?,
        val voteCount: Int?
)

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class MovieBelongsToCollectionDTO (
        val id : Int?,
        val name : String?,
        val posterPath : String?,
        val backdropPath : String?
)

data class GenreDTO (
        val id : Int?,
        val name : String?
)

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class ProductionCompanyDTO (
        val id : Int?,
        val logoPath : String?,
        val name : String?,
        val originCountry : String?
)

data class ProductionCountryDTO(
        @JsonProperty("iso_3166_1")
        val isoName: String?,
        val name: String?
)

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class LanguageDTO (
        val englishName : String?,
        @JsonProperty("iso_639_1")
        val isoName : String?,
        val name : String?
)