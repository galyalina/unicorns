package com.iotta.unicorns

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UnicornsApplication

fun main(args: Array<String>) {
    runApplication<UnicornsApplication>(*args)
}
