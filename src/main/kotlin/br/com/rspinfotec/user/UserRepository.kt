package br.com.rspinfotec.user

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface UserRepository : JpaRepository<User, Long>{

    fun findByUserName(userName: String): User?
}