package br.com.rspinfotec.services.login

import br.com.rspinfotec.dtos.login.LoginRequestDTO
import br.com.rspinfotec.dtos.login.LoginResponseDTO

interface LoginService {
    fun login(payload: LoginRequestDTO): LoginResponseDTO
}