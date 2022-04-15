package com.ddimidyuk.moviespace.registration

import com.ddimidyuk.moviespace.registration.dto.RegistrationRequestDTO
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid

@RestController
@RequestMapping("api/v1/registration")
class RegistrationController(
    private val registrationService: RegistrationService
) {

    @PostMapping
    fun registerNewUser(@RequestBody @Valid requestDTO: RegistrationRequestDTO, request: HttpServletRequest) =
        registrationService.registerNewUser(requestDTO)

    @PostMapping("/confirm")
    fun confirmRegistration(@RequestParam token: String) =
        registrationService.confirmRegistration(token)

}