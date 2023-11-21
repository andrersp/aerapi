package br.com.rspinfotec.services.product

import br.com.rspinfotec.dtos.product.ProductDetailDTO
import br.com.rspinfotec.dtos.product.ProductRequestDTO
import br.com.rspinfotec.dtos.product.ProductResumeDTO

interface ProductService {
    fun create(payload: ProductRequestDTO): ProductDetailDTO

    fun getById(productId: Int): ProductDetailDTO

    fun list(): List<ProductResumeDTO>
}