package br.com.rspinfotec.services.user.impl

import br.com.rspinfotec.repository.UserRepository
import br.com.rspinfotec.services.user.UserService
import br.com.rspinfotec.services.user.dto.UserResponseDTO
import br.com.rspinfotec.shared.security.exceptions.ApiError
import br.com.rspinfotec.shared.security.exceptions.ApiException
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
        val user = userRepository.findByUserName(userName) ?: throw ApiException(ApiError.REGISTRY_NOT_FOUND)

        return UserResponseDTO.fromDomain(user)
    }


}