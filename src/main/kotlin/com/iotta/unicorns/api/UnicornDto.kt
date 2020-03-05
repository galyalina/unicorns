package com.iotta.unicorns.api

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*

@JsonIgnoreProperties(value = ["id"], ignoreUnknown = true)
data class UnicornDto(val id: Long, val name: String, val restTime: Long = 15, var rented: Boolean = false, var returnTime: Date? = null) {
    fun isResting() =
            returnTime?.let {
                (Date().time - it.time) < restTime * 1000
            } ?: false
}
