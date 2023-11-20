package br.com.rspinfotec.services

import br.com.rspinfotec.constants.CategoryConstants.CATEGORIES
import br.com.rspinfotec.constants.CategoryConstants.CATEGORY_1
import br.com.rspinfotec.constants.CategoryConstants.CATEGORY_2
import br.com.rspinfotec.constants.CategoryConstants.CATEGORY_PAYLOAD
import br.com.rspinfotec.dtos.category.CategoryRequestDTO
import br.com.rspinfotec.repository.CategoryRepository
import br.com.rspinfotec.services.category.CategoryService
import br.com.rspinfotec.shared.exceptions.ApiException
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import java.util.*

@MicronautTest(startApplication = false)

class CategoryServiceTest(
    private val categoryService: CategoryService, private val categoryRepository: CategoryRepository
) {
    @MockBean(CategoryRepository::class)
    fun categoryRepository(): CategoryRepository = mock(CategoryRepository::class.java)

    @Test
    fun testListReturnSuccess() {
        `when`(categoryRepository.findAll()).thenReturn(CATEGORIES)
        val sut = categoryService.list()
        assertThat(sut.size).isEqualTo(2)
    }

    @Test
    fun testGetByIdReturnCategory() {
        `when`(categoryRepository.findById(CATEGORY_1.id)).thenReturn(Optional.of(CATEGORY_1))
        val sut = categoryService.findById(1)
        assertThat(sut.name).isEqualTo(CATEGORY_1.name)
    }

    @Test
    fun testGetByIdReturnExceptionNotFound() {
        `when`(categoryRepository.findById(1)).thenReturn(Optional.empty())

        assertThatThrownBy { categoryService.findById(10) }.isInstanceOf(ApiException::class.java)
    }

    @Test
    fun testCreateCategoryReturnCategory() {
        `when`(categoryRepository.findByName(CATEGORY_1.name)).thenReturn(null)
        `when`(categoryRepository.save(CATEGORY_1)).thenReturn(CATEGORY_1)
        val sut = categoryService.create(CATEGORY_PAYLOAD)
        assertThat(sut.name).isEqualTo(CATEGORY_1.name)
    }

    @Test
    fun `when save duplicate name return exception`() {
        `when`(categoryRepository.findByName(CATEGORY_1.name)).thenReturn(CATEGORY_1)

        assertThatThrownBy { categoryService.create(CATEGORY_PAYLOAD) }.isInstanceOf(ApiException::class.java)
    }

    @Test
    fun `when update category return success`() {
        `when`(categoryRepository.findById(CATEGORY_2.id)).thenReturn(Optional.of(CATEGORY_2))
        `when`(categoryRepository.findByName(CATEGORY_2.name)).thenReturn(null)

        val payload = CategoryRequestDTO(
            name = "updated name"
        )
        val sut = categoryService.update(CATEGORY_2.id, payload)
        assertThat(sut.name).isEqualTo(payload.name)

    }

    @Test
    fun `when category not found return exception`() {
        `when`(categoryRepository.findById(1)).thenReturn(Optional.empty())

        val payload = CategoryRequestDTO(
            name = "new test"
        )
        assertThatThrownBy { categoryService.update(CATEGORY_1.id, payload) }.isInstanceOf(ApiException::class.java)
    }

    @Test
    fun `when update with duplicate name return exception`() {
        `when`(categoryRepository.findById(1)).thenReturn(Optional.of(CATEGORY_1))
        `when`(categoryRepository.findByName(CATEGORY_2.name)).thenReturn(CATEGORY_1)

        val payload = CategoryRequestDTO(
            name = CATEGORY_1.name
        )

        assertThatThrownBy {
            categoryService.update(
                categoryId = CATEGORY_2.id,
                payload
            )
        }.isInstanceOf(ApiException::class.java)
    }

}