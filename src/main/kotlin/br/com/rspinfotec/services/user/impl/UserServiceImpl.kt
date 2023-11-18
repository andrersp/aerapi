package br.com.rspinfotec.services.user.impl

import br.com.rspinfotec.dtos.user.UserRequestDTO
import br.com.rspinfotec.dtos.user.UserResponseDTO
import br.com.rspinfotec.entity.User
import br.com.rspinfotec.repository.UserRepository
import br.com.rspinfotec.services.user.UserService
import br.com.rspinfotec.shared.exceptions.ApiError
import br.com.rspinfotec.shared.exceptions.ApiException
import br.com.rspinfotec.shared.security.PasswordEncoder
import jakarta.inject.Singleton

@Singleton
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    override fun getAllUsers(): List<UserResponseDTO> {
        val users = userRepository.findAll()
        return users.map { UserResponseDTO.fromDomain(it) }
    }


    override fun getUserByUserName(userName: String): UserResponseDTO {
        val user =
            userRepository.findByUserName(userName) ?: throw ApiException(ApiError.REGISTRY_NOT_FOUND, "user not found")
        return UserResponseDTO.fromDomain(user)
    }


    override fun createUser(payload: UserRequestDTO): UserResponseDTO {
        val existingUser = userRepository.findByUserName(userName = payload.userName)
        if (existingUser != null) {
            throw ApiException(ApiError.DUPLICATE_REGISTRY, "users already exists, try another")
        }
        val encryptedPassword = PasswordEncoder.hashPassword(payload.password)
        val user = User(userName = payload.userName, password = encryptedPassword)
        userRepository.save(user)

        return UserResponseDTO.fromDomain(user)


    }


}