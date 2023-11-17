package br.com.rspinfotec.services.user

import br.com.rspinfotec.controller.user.dto.UserRequestDTO
import br.com.rspinfotec.controller.user.dto.UserResponseDTO
import br.com.rspinfotec.entity.User

interface UserService {
    fun getAllUsers(): List<User>
    fun getUserByUserName(userName: String): User

    fun createUser(payload: User): User
}