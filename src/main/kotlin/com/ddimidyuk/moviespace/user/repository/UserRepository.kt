package com.ddimidyuk.moviespace.user.repository

import com.ddimidyuk.moviespace.user.User
import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long>{

    fun findByEmail(email: String): User?

    fun findByUserName(userName: String): User?

    @Modifying
    @Query("UPDATE users SET enabled = TRUE WHERE id = :userId")
    fun enableUser(@Param("userId") userId: Long): Boolean
}