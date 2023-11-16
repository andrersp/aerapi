package br.com.rspinfotec.services.login

import br.com.rspinfotec.services.login.dto.LoginRequestDTO
import br.com.rspinfotec.services.login.dto.LoginResponseDTO

interface LoginService {
    fun login(payload: LoginRequestDTO): LoginResponseDTO
}