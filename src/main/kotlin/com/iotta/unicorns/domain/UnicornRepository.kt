package com.iotta.unicorns.domain

import com.iotta.unicorns.api.Unicorn
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Repository
interface UnicornRepository : CrudRepository<Unicorn, Long> {

    fun findByName(name: String): Unicorn?

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Unicorn u SET u.rented = :rented WHERE u.id = :unicornId")
    fun rentUnicorn(unicornId: Long, rented: Boolean = true): Int

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Unicorn u SET u.rented = :rented, u.returnTime = :currentTime WHERE u.id = :unicornId")
    fun returnUnicorn(unicornId: Long, currentTime: Date, rented: Boolean = false): Int
}
