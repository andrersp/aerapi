package br.com.rspinfotec.services

import br.com.rspinfotec.constants.CategoryConstants.CATEGORIES
import br.com.rspinfotec.repository.CategoryRepository
import br.com.rspinfotec.services.category.CategoryService
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@MicronautTest(startApplication = false)

class CategoryServiceTest(
    private val categoryService: CategoryService,
    private val categoryRepository: CategoryRepository
) {
    @MockBean(CategoryRepository::class)
    fun categoryRepository(): CategoryRepository =
        mock(CategoryRepository::class.java)

    @Test
    fun testListReturnSuccess() {
        `when`(categoryRepository.findAll()).thenReturn(CATEGORIES)
        val sut = categoryService.list()
        assertThat(sut.size).isEqualTo(2)
    }

}