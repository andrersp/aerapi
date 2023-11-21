package br.com.rspinfotec.dtos.product

import io.micronaut.serde.annotation.Serdeable
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Positive

@Serdeable
data class ProductRequestDTO(
    @field:Schema(example = "Caneca porcelana")
    @field:NotEmpty
    val name: String,

    @field:Schema(example = "1")
    @field:Positive
    val minimumStock: Int,

    @field:Schema(example = "25.00")
    @field:Positive
    val saleValue: Double,

    @field:Schema(example = "1")
    @field:Positive
    val categoryId: Int


)
