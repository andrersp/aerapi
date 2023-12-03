package br.com.rspinfotec.domain.user

interface UserRepositoryPort {

    fun findAll(): List<User>
    fun findByUserName(userName: String): User?
    fun save(user: User): User
}