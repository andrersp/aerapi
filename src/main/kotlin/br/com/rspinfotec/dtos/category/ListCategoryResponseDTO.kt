package br.com.rspinfotec.dtos.category

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class ListCategoryResponseDTO(
    val total: Long,
    val nextPage: Int? = null,
    val previousPage: Int? = null,
    val content: List<CategoryResponseDTO>
)
