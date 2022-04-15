package com.ddimidyuk.moviespace.registration.token

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RegistrationConfirmationTokenRepository : CrudRepository<RegistrationConfirmationToken, Long>{

    fun findByToken(token: String): RegistrationConfirmationToken?
}