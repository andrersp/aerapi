package br.com.rspinfotec.domain.user

import br.com.rspinfotec.dtos.user.UserRequestDTO
import br.com.rspinfotec.dtos.user.UserResponseDTO

interface UserServicePort {
    fun getAllUsers(): List<UserResponseDTO>
    fun getUserByUserName(userName: String): UserResponseDTO

    fun createUser(payload: UserRequestDTO): UserResponseDTO
}