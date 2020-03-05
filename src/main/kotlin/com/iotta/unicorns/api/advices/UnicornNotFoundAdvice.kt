package com.iotta.unicorns.api.advices

import com.iotta.unicorns.api.exceptions.UnicornException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class UnicornNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(UnicornException.UnicornNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun unicornNotFoundHandler(ex: UnicornException.UnicornNotFoundException): Map<String, String> =
            mapOf("message" to (ex.message ?: "Unicorn not found"))
}

@ControllerAdvice
class UnicornBusyStateAdvice {

    @ResponseBody
    @ExceptionHandler(UnicornException.UnicornIsBusyException::class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    fun illegalStateHandler(ex: UnicornException.UnicornIsBusyException): Map<String, String> =
            mapOf("message" to (ex.message ?: "Unicorn is busy"))
}

@ControllerAdvice
class UnicornIsRestingStateAdvice {

    @ResponseBody
    @ExceptionHandler(UnicornException.UnicornIsRestingException::class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    fun illegalStateHandler(ex: UnicornException.UnicornIsRestingException): Map<String, String> =
            mapOf("message" to (ex.message ?: "Unicorn is resting"))
}


@ControllerAdvice
class UnicornNotRentedStateAdvice {

    @ResponseBody
    @ExceptionHandler(UnicornException.UnicornNotRented::class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    fun illegalStateHandler(ex: UnicornException.UnicornNotRented): Map<String, String> =
            mapOf("message" to (ex.message ?: "Unicorn is not rented, shouldn't be returned"))
}
