package br.com.rspinfotec.services.login

import br.com.rspinfotec.entity.User
import br.com.rspinfotec.controller.login.dto.LoginRequestDTO
import br.com.rspinfotec.controller.login.dto.LoginResponseDTO

interface LoginService {
    fun login(userName: String, password: String): String
}