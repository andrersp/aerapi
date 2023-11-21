package br.com.rspinfotec.dtos.product

import io.micronaut.serde.annotation.Serdeable
import io.swagger.v3.oas.annotations.media.Schema

@Serdeable
data class ProductDetailDTO(
    @field:Schema(example = "1")
    val id: Int,

    @field:Schema(example = "Caneca porcelana")
    val name: String,

    @field:Schema(example = "1")
    val minimumStock: Int,

    @field:Schema(example = "25.00")
    val saleValue: Double,

    @field:Schema(example = "caneca")
    val category: String
)
