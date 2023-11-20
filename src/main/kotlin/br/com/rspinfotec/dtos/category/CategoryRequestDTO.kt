package br.com.rspinfotec.dtos.category

import io.micronaut.serde.annotation.Serdeable
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotEmpty

@Serdeable
data class CategoryRequestDTO(
    @field:Schema(example = "caneca")
    @field:NotEmpty
    val name: String
)
