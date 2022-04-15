package com.ddimidyuk.moviespace.security.config

import com.ddimidyuk.moviespace.user.service.UserService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
class WebSecurityConfig(
    private val userService: UserService,
    @Qualifier("bCryptPasswordEncoder") private val passwordEncoder: PasswordEncoder
) : WebSecurityConfigurerAdapter(false) {

    override fun configure(http: HttpSecurity) {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/api/v*/registration/**")
            .permitAll()
            .anyRequest()
            .authenticated().and()
            .formLogin()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(daoAuthenticationProvider())
    }

    @Bean
    fun daoAuthenticationProvider() = DaoAuthenticationProvider().apply {
        setPasswordEncoder(passwordEncoder)
        setUserDetailsService(userService)
    }

}