package com.ddimidyuk.moviespace.registration

import com.ddimidyuk.moviespace.notification.NotificationSender
import com.ddimidyuk.moviespace.notification.type.RegistrationConfirmationNotification
import com.ddimidyuk.moviespace.registration.dto.RegistrationRequestDTO
import com.ddimidyuk.moviespace.registration.exception.ConfirmationTokenNotAcceptableException
import com.ddimidyuk.moviespace.registration.token.RegistrationConfirmationToken
import com.ddimidyuk.moviespace.registration.token.RegistrationConfirmationTokenRepository
import com.ddimidyuk.moviespace.registration.token.isExpired
import com.ddimidyuk.moviespace.user.User
import com.ddimidyuk.moviespace.user.service.UserService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.*

@Service
class RegistrationService(
    private val registrationRequestConverter: RegistrationRequestConverter,
    private val userService: UserService,
    private val registrationConfirmationTokenRepository: RegistrationConfirmationTokenRepository,
    private val notificationSender: NotificationSender
) {

    companion object {
        const val VERIFICATION_EXPIRATION_MINUTES = 15L
    }

    @Transactional
    fun registerNewUser(registrationRequestDTO: RegistrationRequestDTO) {
        val user = registrationRequestConverter.convert(registrationRequestDTO)
            .let { userService.createUser(it) }

        sendConfirmationLink(user)
    }

    @Transactional
    fun confirmRegistration(token: String) {
        val confirmationToken = registrationConfirmationTokenRepository.findByToken(token)
        if (confirmationToken == null || confirmationToken.isExpired()) {
            throw ConfirmationTokenNotAcceptableException("Confirmation link is invalid, please try to register again")
        }
        userService.enableUser(confirmationToken.userId)
    }

    private fun sendConfirmationLink(user: User) {
        val confirmationToken = createNewConfirmationToken(user)
        RegistrationConfirmationNotification(
            recipientEmail = user.email,
            name = user.name,
            confirmationLink = "http://localhost:8080/api/v1/registration/confirm?token=${confirmationToken.token}"
        ).let { notificationSender.sendNotification(it) }
    }

    private fun createNewConfirmationToken(user: User): RegistrationConfirmationToken {
        return RegistrationConfirmationToken(
            userId = user.id!!,
            token = UUID.randomUUID().toString(),
            expiresAt = LocalDateTime.now().plusMinutes(VERIFICATION_EXPIRATION_MINUTES),
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now(),
        ).let { registrationConfirmationTokenRepository.save(it) }
    }

}