package br.com.rspinfotec.user

import br.com.rspinfotec.shared.security.JwtUtil
import br.com.rspinfotec.shared.security.PasswordEncoder
import br.com.rspinfotec.user.dto.LoginRequestDTO
import br.com.rspinfotec.user.dto.LoginResponseDTO
import br.com.rspinfotec.user.dto.UserResponseDTO
import jakarta.inject.Singleton

@Singleton
class UserService(
    private val userRepository: UserRepository,
    private val jwtUtil: JwtUtil
) {

    fun login(payload: LoginRequestDTO): LoginResponseDTO {
        val user = getUserByUserName(payload.userName)
        if (!PasswordEncoder.checkPassword(payload.password, user.password)) throw Exception("Password errado")
        val accessToken = jwtUtil.generateJwtToken(userName = user.userName, userId = user.id)
        return LoginResponseDTO(
            userName = user.userName,
            accessToken = accessToken
        )
    }

    fun getAllUsers(): List<UserResponseDTO>{
        val users = userRepository.findAll()
        return users.map { return@map UserResponseDTO.fromDomain(it) }
    }


    fun getUserByUserName(userName: String): User =
        userRepository.findByUserName(userName) ?: throw Exception("user no found")


}