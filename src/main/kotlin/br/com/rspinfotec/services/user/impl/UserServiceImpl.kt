package br.com.rspinfotec.services.user.impl

import br.com.rspinfotec.repository.UserRepository
import br.com.rspinfotec.services.user.UserService
import br.com.rspinfotec.services.user.dto.UserResponseDTO
import br.com.rspinfotec.shared.security.JwtUtil
import jakarta.inject.Singleton

@Singleton
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    override fun getAllUsers(): List<UserResponseDTO> {
        val users = userRepository.findAll()
        return users.map { return@map UserResponseDTO.fromDomain(it) }
    }


    override fun getUserByUserName(userName: String): UserResponseDTO {
        val user = userRepository.findByUserName(userName) ?: throw Exception("user no found")

        return UserResponseDTO.fromDomain(user)
    }


}