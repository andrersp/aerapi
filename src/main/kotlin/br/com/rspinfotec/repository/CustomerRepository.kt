package br.com.rspinfotec.repository

import br.com.rspinfotec.domain.Customer
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface CustomerRepository : JpaRepository<Customer, Long> {

    fun findByPhone(phone: String): Customer?
}