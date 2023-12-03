package br.com.rspinfotec.domain.user.impl

import br.com.rspinfotec.domain.user.User
import br.com.rspinfotec.domain.user.UserRepositoryPort
import br.com.rspinfotec.domain.user.UserServicePort
import br.com.rspinfotec.dtos.user.UserRequestDTO
import br.com.rspinfotec.dtos.user.UserResponseDTO
import br.com.rspinfotec.shared.exceptions.ApiError
import br.com.rspinfotec.shared.exceptions.ApiException
import br.com.rspinfotec.shared.security.PasswordEncoder


class UserServiceImpl(
    private val repository: UserRepositoryPort
) : UserServicePort {

    override fun getAllUsers(): List<UserResponseDTO> {
        val users = repository.findAll()
        return users.map { UserResponseDTO.fromDomain(it) }
    }


    override fun getUserByUserName(userName: String): UserResponseDTO {
        val user =
            repository.findByUserName(userName) ?: throw ApiException(ApiError.REGISTRY_NOT_FOUND, "user not found")
        return UserResponseDTO.fromDomain(user)
    }

    override fun createUser(payload: UserRequestDTO): UserResponseDTO {
        val existingUser = repository.findByUserName(userName = payload.userName)
        if (existingUser != null) {
            throw ApiException(ApiError.DUPLICATE_REGISTRY, "users already exists, try another")
        }
        val encryptedPassword = PasswordEncoder.hashPassword(payload.password)
        val user = User(userName = payload.userName, password = encryptedPassword)
        repository.save(user)

        return UserResponseDTO.fromDomain(user)


    }


}