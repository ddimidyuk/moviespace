package com.ddimidyuk.moviespace.registration.token

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("registration_confirm_token")
data class RegistrationConfirmationToken(
    @Id
    val id: Long? = null,
    val userId: Long,
    val token: String,
    val expiresAt: LocalDateTime,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)

fun RegistrationConfirmationToken.isExpired() = LocalDateTime.now().isAfter(this.expiresAt)