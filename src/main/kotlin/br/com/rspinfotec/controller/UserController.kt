package br.com.rspinfotec.controller

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
    fun getAllUsers() = userService.getAllUsers()

}