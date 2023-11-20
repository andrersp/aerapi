package br.com.rspinfotec.services.category.impl

import br.com.rspinfotec.dtos.category.CategoryRequestDTO
import br.com.rspinfotec.dtos.category.CategoryResponseDTO
import br.com.rspinfotec.entity.Category
import br.com.rspinfotec.repository.CategoryRepository
import br.com.rspinfotec.services.category.CategoryService
import br.com.rspinfotec.shared.exceptions.ApiError
import br.com.rspinfotec.shared.exceptions.ApiException
import jakarta.inject.Singleton

@Singleton
class CategoryServiceImpl(
    private val categoryRepository: CategoryRepository
) : CategoryService {
    override fun create(payload: CategoryRequestDTO): CategoryResponseDTO {
        val existingCategory = categoryRepository.findByName(payload.name)
        existingCategory?.let {
            throw ApiException(ApiError.DUPLICATE_REGISTRY, "category name existing")
        }
        val category = Category(name = payload.name)
        categoryRepository.save(category)

        return CategoryResponseDTO(
            id = category.id, name = category.name
        )
    }

    override fun list(): List<CategoryResponseDTO> {
        val categories = categoryRepository.findAll()
        return categories.map { category ->
            CategoryResponseDTO(
                id = category.id, name = category.name
            )
        }
    }

    override fun update(categoryId: Int, payload: CategoryRequestDTO): CategoryResponseDTO {

        val existingCategory = categoryRepository.findByName(payload.name)

        existingCategory?.let {
            if (it.id != categoryId)
                throw ApiException(ApiError.DUPLICATE_REGISTRY, "category name existing")
        }

        val category = categoryRepository.findById(categoryId).orElseThrow {
            ApiException(
                ApiError.REGISTRY_NOT_FOUND, "category not found"
            )
        }

        category.name = payload.name
        categoryRepository.merge(category)
        return CategoryResponseDTO(id = category.id, name = category.name)
    }

    override fun findById(categoryId: Int): CategoryResponseDTO {
        val category = categoryRepository.findById(categoryId).orElseThrow {
            ApiException(
                ApiError.REGISTRY_NOT_FOUND, "category not found"
            )
        }
        return CategoryResponseDTO(
            id = category.id, name = category.name
        )
    }


}