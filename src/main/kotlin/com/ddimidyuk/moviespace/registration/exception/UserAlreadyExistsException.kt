package com.ddimidyuk.moviespace.registration.exception

class UserAlreadyExistsException(override val message: String) : Exception(message)