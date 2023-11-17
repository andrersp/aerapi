package br.com.rspinfotec.controller.user

import br.com.rspinfotec.controller.user.dto.UserResponseDTO
import br.com.rspinfotec.services.user.UserService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.validation.Validated
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag


@Controller("/users")
@Tag(name = "User")
@Validated
class UserController(
    private val userService: UserService,
) {

    @Get
    @Operation(summary = "get all users", description = "get all users data")
    fun getAllUsers(): List<UserResponseDTO> {
        val users = userService.getAllUsers()
        return users.map { UserResponseDTO.fromDomain(it) }
    }

}