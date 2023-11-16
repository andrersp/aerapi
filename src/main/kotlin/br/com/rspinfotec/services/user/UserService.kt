package br.com.rspinfotec.services.user

import br.com.rspinfotec.services.login.dto.LoginRequestDTO
import br.com.rspinfotec.services.login.dto.LoginResponseDTO
import br.com.rspinfotec.services.user.dto.UserResponseDTO

interface UserService {
    fun getAllUsers(): List<UserResponseDTO>

    fun getUserByUserName(userName: String): UserResponseDTO
}