package br.com.rspinfotec.repository

import br.com.rspinfotec.domain.user.User
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findByUserName(userName: String): User?
}