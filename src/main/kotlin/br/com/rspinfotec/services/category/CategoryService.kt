package br.com.rspinfotec.services.category

import br.com.rspinfotec.dtos.category.CategoryRequestDTO
import br.com.rspinfotec.dtos.category.CategoryResponseDTO

interface CategoryService {
    fun create(payload: CategoryRequestDTO): CategoryResponseDTO

    fun list(): List<CategoryResponseDTO>

    fun update(categoryId: Int, payload: CategoryRequestDTO): CategoryResponseDTO

    fun findById(categoryId: Int): CategoryResponseDTO
}