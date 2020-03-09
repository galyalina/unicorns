package com.iotta.unicorns.api.exceptions

sealed class UnicornException(message: String) : RuntimeException(message) {
    class UnicornNotFoundException(name: String) : UnicornException("Unicorn with name = $name not found")
    class UnicornNotRented(name: String) : UnicornException("Unicorn with name = $name not rented")
    class UnicornIsBusyException(name: String?) : UnicornException("Unicorn with name = $name is busy")
    class UnicornIsRestingException(name: String?) : UnicornException("Unicorn with name = $name is resting")
    class UnicornGeneralException(message: String?) : UnicornException("Something bad happened to our unicorn stalls, please try later, some details:  $message")
}
