package com.ddimidyuk.moviespace.user.controller

import com.ddimidyuk.moviespace.user.service.UserService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/user")
class UserController(
    private val userService: UserService
) {

}