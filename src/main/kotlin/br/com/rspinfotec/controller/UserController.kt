package br.com.rspinfotec.controller

import br.com.rspinfotec.domain.user.UserServicePort
import br.com.rspinfotec.dtos.user.UserRequestDTO
import br.com.rspinfotec.dtos.user.UserResponseDTO
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid

@Controller("/users")
@Tag(name = "User")
@Validated
class UserController(
    private val userService: UserServicePort,
) {

    @Get
    @Operation(summary = "get all users", description = "get all users data")
    fun getAllUsers(): List<UserResponseDTO> =
        userService.getAllUsers()

    @Post
    @Operation(summary = "create user", description = "Create a new user")
    @Status(HttpStatus.CREATED)
    fun createNewUser(@Valid @Body payload: UserRequestDTO): UserResponseDTO =
        userService.createUser(payload)
}