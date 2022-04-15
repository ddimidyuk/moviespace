package com.ddimidyuk.moviespace.common.dto

import java.time.LocalDateTime

data class ErrorResponseDto(
    val date: LocalDateTime = LocalDateTime.now(),
    val message: String,
    val details: List<String> = emptyList()
)