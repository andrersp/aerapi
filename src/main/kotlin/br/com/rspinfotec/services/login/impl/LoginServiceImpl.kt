package br.com.rspinfotec.services.login.impl

import br.com.rspinfotec.services.login.LoginService
import br.com.rspinfotec.controller.login.dto.LoginRequestDTO
import br.com.rspinfotec.services.user.UserService
import br.com.rspinfotec.shared.security.JwtUtil
import br.com.rspinfotec.shared.security.PasswordEncoder
import jakarta.inject.Singleton

@Singleton
class LoginServiceImpl(private val userService: UserService, private val jwtUtil: JwtUtil) : LoginService {
    override fun login(userName: String, password: String): String {
        val user = userService.getUserByUserName(userName)
        if (!PasswordEncoder.checkPassword(password, user.password)) throw Exception("Password errado")
        return jwtUtil.generateJwtToken(userName = user.userName, userId = user.id)
    }


}