package br.com.rspinfotec.constants

import br.com.rspinfotec.domain.Product
import br.com.rspinfotec.dtos.product.ProductRequestDTO

object ProductConstants {

    val PRODUCT_REQUEST = ProductRequestDTO(
        name = "product test",
        saleValue = 12.50,
        minimumStock = 10,
        categoryId = 1
    )
    val PRODUCT_1 = Product(
        id = 1,
        name = "product test",
        saleValue = 12.50,
        minimumStock = 10,
        category = CategoryConstants.CATEGORY_1
    )

    val PRODUCT_2 = Product(
        id = 2,
        name = "product test 2",
        saleValue = 12.50,
        minimumStock = 10,
        category = CategoryConstants.CATEGORY_2
    )
}