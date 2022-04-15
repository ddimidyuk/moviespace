package com.ddimidyuk.moviespace.user.service

import com.ddimidyuk.moviespace.registration.exception.UserAlreadyExistsException
import com.ddimidyuk.moviespace.user.User
import com.ddimidyuk.moviespace.user.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(userName: String) =
        userRepository.findByUserName(userName) ?: throw UsernameNotFoundException("User with username '$userName' not found")

    @Transactional
    fun createUser(user: User): User {
        if (!checkIfUserExists(user)) {
            return userRepository.save(user)
        } else {
            throw UserAlreadyExistsException("User with such email or username already exists")
        }
    }

    @Transactional
    fun enableUser(userId: Long) = userRepository.enableUser(userId)

    fun checkIfUserExists(user: User): Boolean {
        return userRepository.findByEmail(user.email) != null && userRepository.findByUserName(user.userName ) != null
    }

}