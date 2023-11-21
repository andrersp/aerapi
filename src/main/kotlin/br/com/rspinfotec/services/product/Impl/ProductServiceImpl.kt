package br.com.rspinfotec.services.product.Impl

import br.com.rspinfotec.dtos.product.ProductDetailDTO
import br.com.rspinfotec.dtos.product.ProductRequestDTO
import br.com.rspinfotec.dtos.product.ProductResumeDTO
import br.com.rspinfotec.services.product.ProductService
import jakarta.inject.Singleton

@Singleton
class ProductServiceImpl : ProductService {
    override fun create(payload: ProductRequestDTO): ProductDetailDTO {
        TODO("Not yet implemented")
    }

    override fun getById(productId: Int): ProductDetailDTO {
        TODO("Not yet implemented")
    }

    override fun list(): List<ProductResumeDTO> {
        TODO("Not yet implemented")
    }
}