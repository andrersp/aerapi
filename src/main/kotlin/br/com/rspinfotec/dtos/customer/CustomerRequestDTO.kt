package br.com.rspinfotec.dtos.customer

import io.micronaut.serde.annotation.Serdeable
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotEmpty

@Serdeable
data class CustomerRequestDTO(
    @field:Schema(example = "Full customer name")
    @field:NotEmpty
    val name: String,

    @field:Schema(example = "01345678901")
    @field:NotEmpty
    val phone: String,

    @field:Schema(example = "Free text about customer")
    val obs: String
)
