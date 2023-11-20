package br.com.rspinfotec.controller

import br.com.rspinfotec.dtos.category.CategoryRequestDTO
import br.com.rspinfotec.dtos.category.CategoryResponseDTO
import br.com.rspinfotec.services.category.CategoryService
import br.com.rspinfotec.shared.exceptions.ApiErrorMessage
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import jakarta.validation.constraints.Positive

@Controller("/category")
@Tag(name = "Category")
@ApiResponse(responseCode = "400", content = [Content(schema = Schema(implementation = ApiErrorMessage::class))])
@Validated
class CategoryController(
    private val categoryService: CategoryService
) {
    @Get
    @Operation(description = "Get All Category", summary = "Get categories")
    fun list(): List<CategoryResponseDTO> = categoryService.list()

    @Get("/{categoryId}")
    @Operation(summary = "Get By id", description = "Get category by id")
    fun getById(@Positive categoryId: Int): CategoryResponseDTO = categoryService.findById(categoryId)

    @Post
    @Operation(summary = "Create", description = "Create new category")
    @Status(HttpStatus.CREATED)
    fun create(@Valid @Body payload: CategoryRequestDTO): CategoryResponseDTO = categoryService.create(payload)

    @Put("/{categoryId}")
    @Operation(summary = "Update", description = "Update category")
    fun update(@Positive categoryId: Int, @Valid @Body payload: CategoryRequestDTO): CategoryResponseDTO =
        categoryService.update(categoryId, payload)


}