package br.com.rspinfotec.dtos.user

import io.micronaut.serde.annotation.Serdeable.Deserializable
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

@Deserializable
data class UserRequestDTO(
    @Schema(example = "username")
    @field:NotEmpty
    @Size(max = 20)
    val userName: String,

    @Schema(example = "mypassword")
    @field:NotEmpty
    @field:Size(min = 6, max = 20)
    val password: String

)
