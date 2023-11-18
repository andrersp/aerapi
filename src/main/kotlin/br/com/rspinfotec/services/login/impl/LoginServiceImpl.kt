package br.com.rspinfotec.services.login.impl

import br.com.rspinfotec.dtos.login.LoginRequestDTO
import br.com.rspinfotec.dtos.login.LoginResponseDTO
import br.com.rspinfotec.repository.UserRepository
import br.com.rspinfotec.services.login.LoginService
import br.com.rspinfotec.shared.exceptions.ApiError
import br.com.rspinfotec.shared.exceptions.ApiException
import br.com.rspinfotec.shared.security.JwtUtil
import br.com.rspinfotec.shared.security.PasswordEncoder
import jakarta.inject.Singleton

@Singleton
class LoginServiceImpl(private val userRepository: UserRepository, private val jwtUtil: JwtUtil) : LoginService {
    override fun login(payload: LoginRequestDTO): LoginResponseDTO {

        val user =
            userRepository.findByUserName(payload.userName) ?: throw ApiException(ApiError.INVALID_AUTHENTICATION)
        if (!PasswordEncoder.checkPassword(
                payload.password,
                user.password
            )
        ) throw ApiException(ApiError.INVALID_AUTHENTICATION)
        val jwtToken = jwtUtil.generateJwtToken(userName = user.userName, userId = user.id)

        return LoginResponseDTO(
            userName = user.userName,
            accessToken = jwtToken
        )
    }


}