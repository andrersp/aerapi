package br.com.rspinfotec.controller.login

import br.com.rspinfotec.controller.login.dto.LoginRequestDTO
import br.com.rspinfotec.controller.login.dto.LoginResponseDTO
import br.com.rspinfotec.services.login.LoginService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.micronaut.validation.Validated
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid

@Controller("/login")
@Tag(name = "Login")
@Secured(SecurityRule.IS_ANONYMOUS)
@Validated
class LoginController(private val loginService: LoginService) {

    @Post
    @Operation(summary = "login", description = "endpoint login")
    fun login(@Valid @Body payload: LoginRequestDTO): LoginResponseDTO {

        val accessToken = loginService.login(payload.userName, payload.password)
        return LoginResponseDTO(
            accessToken = accessToken
        )


    }

}