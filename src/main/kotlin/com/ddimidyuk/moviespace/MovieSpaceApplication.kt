package com.ddimidyuk.moviespace

import com.ddimidyuk.moviespace.webclient.property.TMDbProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(TMDbProperties::class)
class MovieSpaceApplication

fun main(args: Array<String>) {
	runApplication<MovieSpaceApplication>(*args)
}
