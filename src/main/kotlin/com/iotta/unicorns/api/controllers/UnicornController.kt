package com.iotta.unicorns.api.controllers

import com.iotta.unicorns.api.UnicornDto
import com.iotta.unicorns.api.exceptions.UnicornException
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.concurrent.atomic.AtomicLong

@RestController
class UnicornController {

    private final val counter = AtomicLong()
    private val unicorns = mutableListOf<UnicornDto>(
            UnicornDto(id = 1, name = "Pinky Pie"),
            UnicornDto(id = 2, name = "Rainbow Dash"),
            UnicornDto(id = 3, name = "Fluttershy"),
            UnicornDto(id = 4, name = "Twilight Sparkle", restTime = 30)
    )

    @GetMapping("/unicorns/rentals")
    fun getUnicorn(@RequestParam(value = "name") name: String): UnicornDto {
        val unicorn = unicorns.find {
            it.name == name
        } ?: throw UnicornException.UnicornNotFoundException(name)

        if (unicorn.rented) throw UnicornException.UnicornIsBusyException(name)
        if (unicorn.isResting()) throw UnicornException.UnicornIsRestingException(name)

        return unicorn.apply {
            rented = true
        }
    }

    @PatchMapping("/unicorns/rentals")
    fun patchUnicorn(@RequestParam(value = "name") name: String): UnicornDto {
        val unicorn = unicorns.find { it.name == name }
        unicorn?.apply {
            if (rented.not()) throw UnicornException.UnicornNotRented(name) else {
                rented = false
                returnTime = Date()
            }
        } ?: throw UnicornException.UnicornNotFoundException(name)
        return unicorn
    }
}
