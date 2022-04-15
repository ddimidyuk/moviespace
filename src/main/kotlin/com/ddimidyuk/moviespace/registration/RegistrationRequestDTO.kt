package com.ddimidyuk.moviespace.registration.dto

import com.ddimidyuk.moviespace.registration.validation.PasswordMatches
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

@PasswordMatches
data class RegistrationRequestDTO(

    @field:NotEmpty(message = "Username must not be empty")
    val userName: String,

    @field:NotEmpty(message = "Name must not be empty")
    val name: String,

    @field:[Email(message = "Email must be valid") NotEmpty(message = "Email must not be empty")]
    val email: String,

    @field:NotEmpty(message = "Password must not be empty")
    val password: String,

    @field:NotEmpty(message = "Confirmed password must not be empty")
    val confirmPassword: String?
)