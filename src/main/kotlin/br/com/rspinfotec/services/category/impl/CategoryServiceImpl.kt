package br.com.rspinfotec.services.category.impl

import br.com.rspinfotec.dtos.category.CategoryRequestDTO
import br.com.rspinfotec.dtos.category.CategoryResponseDTO
import br.com.rspinfotec.repository.CategoryRepository
import br.com.rspinfotec.services.category.CategoryService
import jakarta.inject.Singleton

@Singleton
class CategoryServiceImpl(
    private val categoryRepository: CategoryRepository
) : CategoryService {
    override fun create(payload: CategoryRequestDTO): CategoryResponseDTO {
        TODO("Not yet implemented")
    }

    override fun list(): List<CategoryResponseDTO> {
        val categories = categoryRepository.findAll()
        return categories.map { category ->
            CategoryResponseDTO(
                id = category.id,
                name = category.name
            )
        }
    }

    override fun update(categoryId: Int, payload: CategoryRequestDTO): CategoryResponseDTO {
        TODO("Not yet implemented")
    }

    override fun findById(categoryId: Int): CategoryResponseDTO {
        TODO("Not yet implemented")
    }
}