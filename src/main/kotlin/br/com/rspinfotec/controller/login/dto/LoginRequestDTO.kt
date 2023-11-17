package br.com.rspinfotec.controller.login.dto

import io.micronaut.serde.annotation.Serdeable
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotEmpty

@Serdeable
data class LoginRequestDTO(
    @Schema(example = "username") @field:NotEmpty val userName: String,

    @field:NotEmpty
//    @field:Size(min = 6, max = 20)
    @Schema(example = "password") val password: String
)
