package br.com.rspinfotec.services.user

import br.com.rspinfotec.dtos.user.UserRequestDTO
import br.com.rspinfotec.dtos.user.UserResponseDTO

interface UserService {
    fun getAllUsers(): List<UserResponseDTO>
    fun getUserByUserName(userName: String): UserResponseDTO

    fun createUser(payload: UserRequestDTO): UserResponseDTO
}