package com.ddimidyuk.moviespace.registration.validation

import com.ddimidyuk.moviespace.registration.dto.RegistrationRequestDTO
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class PasswordMatchesValidator : ConstraintValidator<PasswordMatches, Any> {

    override fun isValid(obj: Any?, context: ConstraintValidatorContext?): Boolean =
        (obj as RegistrationRequestDTO).let { return it.password == it.confirmPassword }

}