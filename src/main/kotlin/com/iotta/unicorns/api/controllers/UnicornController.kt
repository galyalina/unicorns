package com.iotta.unicorns.api.controllers

import com.iotta.unicorns.api.Unicorn
import com.iotta.unicorns.api.UnicornDto
import com.iotta.unicorns.api.exceptions.UnicornException
import com.iotta.unicorns.domain.UnicornRepository
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.concurrent.atomic.AtomicLong

@RestController
class UnicornController(private val repository: UnicornRepository) {

    private final val counter = AtomicLong()

    @Throws(Exception::class)
    @GetMapping("/unicorns/rentals")
    fun getUnicorn(@RequestParam(value = "name") name: String): UnicornDto {
        try {
            repository.findByName(name)?.toUnicornDto()?.let { unicorn ->
                if (unicorn.rented) throw UnicornException.UnicornIsBusyException(name)
                if (unicorn.checkIfResting()) throw UnicornException.UnicornIsRestingException(name)
                repository.rentUnicorn(unicornId = unicorn.id)
                return unicorn
            } ?: throw UnicornException.UnicornNotFoundException(name)
        } catch (error: Exception) {
            if (error is UnicornException) {
                throw error
            } else
                throw UnicornException.UnicornGeneralException(error.message)
        }
    }

    @Throws(Exception::class)
    @PatchMapping("/unicorns/rentals")
    fun patchUnicorn(@RequestParam(value = "name") name: String): UnicornDto {
        try {
            repository.findByName(name)?.toUnicornDto()?.let { unicorn ->
                if (unicorn.rented.not()) throw UnicornException.UnicornNotRented(name)
                else {
                    repository.returnUnicorn(unicorn.id, Date())
                }
                return unicorn
            } ?: throw UnicornException.UnicornNotFoundException(name)
        } catch (error: Exception) {
            if (error is UnicornException) {
                throw error
            } else
                throw UnicornException.UnicornGeneralException(error.message)
        }
    }
}

private fun Unicorn.toUnicornDto(): UnicornDto? {
    return id?.let { UnicornDto(it, name, restTime, rented, returnTime) }
}
