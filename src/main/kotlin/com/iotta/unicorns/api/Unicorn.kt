package com.iotta.unicorns.api

import java.util.*
import javax.persistence.*

@Entity
@NamedQuery(name = "Unicorn.findByName",
        query = "select u from Unicorn u where u.name = ?1")
class Unicorn(
        @Id @GeneratedValue var id: Long? = null,
        val name: String = "",
        @Column(name = "rest_time")
        val restTime: Long = 15,
        var rented: Boolean = false,
        @Column(name = "return_time")
        var returnTime: Date? = null
)
