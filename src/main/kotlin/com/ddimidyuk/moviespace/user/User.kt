package com.ddimidyuk.moviespace.user

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.LocalDateTime

@Table("users")
data class User(
    @Id
    val id: Long? = null,
    val userName: String,
    val email: String,
    private val password: String,
    val name: String,
    val role: UserRole,
    val locked: Boolean,
    val enabled: Boolean,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) : UserDetails {
    override fun getAuthorities() = listOf(SimpleGrantedAuthority(role.value))
    override fun getPassword() = password
    override fun getUsername() = userName
    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = !locked
    override fun isCredentialsNonExpired() = true
    override fun isEnabled() = enabled
}