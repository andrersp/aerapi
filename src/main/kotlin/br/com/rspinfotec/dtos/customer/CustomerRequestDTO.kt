package br.com.rspinfotec.dtos.customer

import io.micronaut.serde.annotation.Serdeable
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotEmpty

@Serdeable
data class CustomerRequestDTO(
    @Schema(example = "Full customer name")
    @field:NotEmpty
    val name: String,

    @Schema(example = "01345678901")
    @field:NotEmpty
    val phone: String,

    @Schema(example = "Free text about customer")
    @field:NotEmpty
    val obs: String
)
