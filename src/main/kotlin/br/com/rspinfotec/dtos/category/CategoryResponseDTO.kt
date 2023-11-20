package br.com.rspinfotec.dtos.category

import io.micronaut.serde.annotation.Serdeable
import io.swagger.v3.oas.annotations.media.Schema

@Serdeable
data class CategoryResponseDTO(
    @field:Schema(example = "1")
    val id: Int,

    @field:Schema(example = "Caneca")
    val name: String
)
