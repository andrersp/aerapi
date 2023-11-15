package br.com.rspinfotec.user

import br.com.rspinfotec.shared.security.JwtUtil
import br.com.rspinfotec.shared.security.PasswordEncoder
import br.com.rspinfotec.user.dto.LoginRequestDTO
import br.com.rspinfotec.user.dto.LoginResponseDTO
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import io.micronaut.validation.Validated
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid

@Controller("/users")
@Tag(name = "User")
@Secured(SecurityRule.IS_ANONYMOUS)
@Validated
class UserController(
    private val userService: UserService,

) {
    @Post("/login")
    @Operation(summary = "login", description = "endpoint login")
    fun createUser(@Valid @Body payload: LoginRequestDTO): LoginResponseDTO =
        userService.login(payload)

    @Get
    @Operation(summary = "get all users", description = "get all users data")
    fun getAllUsers() = userService.getAllUsers()

}