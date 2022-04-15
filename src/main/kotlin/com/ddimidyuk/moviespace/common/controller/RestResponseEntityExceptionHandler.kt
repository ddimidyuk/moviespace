package com.ddimidyuk.moviespace.common.controller

import com.ddimidyuk.moviespace.common.dto.ErrorResponseDto
import com.ddimidyuk.moviespace.registration.exception.ConfirmationTokenNotAcceptableException
import com.ddimidyuk.moviespace.registration.exception.UserAlreadyExistsException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleUnknownError(ex: Exception, request: WebRequest) =
        ResponseEntity(ErrorResponseDto(message = "Something has went wrong"), HttpStatus.BAD_REQUEST)

    @ExceptionHandler(UserAlreadyExistsException::class)
    fun handleUserAlreadyExistsException(ex: UserAlreadyExistsException, request: WebRequest) =
        ResponseEntity(ErrorResponseDto(message = ex.message), HttpStatus.BAD_REQUEST)

    @ExceptionHandler(ConfirmationTokenNotAcceptableException::class)
    fun handleConfirmationTokenNotAcceptableException(
        ex: ConfirmationTokenNotAcceptableException,
        request: WebRequest
    ) = ResponseEntity(ErrorResponseDto(message = ex.message), HttpStatus.BAD_REQUEST)

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val errorDto = ErrorResponseDto(
            message = "Validation failed",
            details = ex.bindingResult.allErrors.mapNotNull { it.defaultMessage }.toList()
        )
        return ResponseEntity(errorDto, HttpStatus.BAD_REQUEST)

    }

}