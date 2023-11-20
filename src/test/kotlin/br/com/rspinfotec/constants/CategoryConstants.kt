package br.com.rspinfotec.constants

import br.com.rspinfotec.dtos.category.CategoryRequestDTO
import br.com.rspinfotec.entity.Category

object CategoryConstants {
    val CATEGORY_PAYLOAD = CategoryRequestDTO(name = "caneca")
    val CATEGORY_1 = Category(id = 1, name = "caneca")
    val CATEGORY_2 = Category(id = 2, name = "camisa")
    val CATEGORIES = listOf(CATEGORY_1, CATEGORY_2)
}