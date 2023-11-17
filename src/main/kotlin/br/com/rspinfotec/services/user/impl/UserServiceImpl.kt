package br.com.rspinfotec.services.user.impl

import br.com.rspinfotec.entity.User
import br.com.rspinfotec.repository.UserRepository
import br.com.rspinfotec.services.user.UserService
import br.com.rspinfotec.shared.security.PasswordEncoder
import br.com.rspinfotec.shared.security.exceptions.ApiError
import br.com.rspinfotec.shared.security.exceptions.ApiException
import jakarta.inject.Singleton

@Singleton
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    override fun getAllUsers(): List<User> {
        val users = userRepository.findAll()
        return users
    }


    override fun getUserByUserName(userName: String): User =
        userRepository.findByUserName(userName) ?: throw ApiException(ApiError.REGISTRY_NOT_FOUND)


    override fun createUser(payload: User): User {
        val existingUser = userRepository.findByUserName(userName = payload.userName)
        if (existingUser != null) {
            throw ApiException(ApiError.DUPLICATE_REGISTER)
        }
        payload.password = PasswordEncoder.hashPassword(payload.password)
        return  userRepository.save(payload)


    }


}