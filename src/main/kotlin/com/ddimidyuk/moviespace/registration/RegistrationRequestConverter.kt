package com.ddimidyuk.moviespace.registration

import com.ddimidyuk.moviespace.registration.dto.RegistrationRequestDTO
import com.ddimidyuk.moviespace.user.User
import com.ddimidyuk.moviespace.user.UserRole.USER
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.core.convert.converter.Converter
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class RegistrationRequestConverter(
    @Qualifier("bCryptPasswordEncoder") private val passwordEncoder: PasswordEncoder
) : Converter<RegistrationRequestDTO, User> {

    override fun convert(request: RegistrationRequestDTO) = User(
        userName = request.userName,
        email = request.email,
        password = passwordEncoder.encode(request.password),
        name = request.name,
        role = USER,
        locked = false,
        enabled = false,
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now()
    )
}