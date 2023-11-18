package br.com.rspinfotec.controller

import br.com.rspinfotec.dtos.login.LoginRequestDTO
import br.com.rspinfotec.dtos.login.LoginResponseDTO
import br.com.rspinfotec.services.login.LoginService
import br.com.rspinfotec.shared.exceptions.ApiErrorMessage
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.micronaut.validation.Validated
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid

@Controller("/login")
@Tag(name = "Login")
@Secured(SecurityRule.IS_ANONYMOUS)
@ApiResponse(responseCode = "400", content = [Content(schema = Schema(implementation = ApiErrorMessage::class))])
@Validated
class LoginController(private val loginService: LoginService) {

    @Post
    @Operation(summary = "login", description = "endpoint login")
    fun login(@Valid @Body payload: LoginRequestDTO): LoginResponseDTO =
        loginService.login(payload = payload)

}