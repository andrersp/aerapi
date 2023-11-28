package br.com.rspinfotec.services.product.Impl

import br.com.rspinfotec.dtos.product.ProductDetailDTO
import br.com.rspinfotec.dtos.product.ProductRequestDTO
import br.com.rspinfotec.dtos.product.ProductResumeDTO
import br.com.rspinfotec.entity.Product
import br.com.rspinfotec.repository.CategoryRepository
import br.com.rspinfotec.repository.ProductRepository
import br.com.rspinfotec.services.product.ProductService
import br.com.rspinfotec.shared.exceptions.ApiError
import br.com.rspinfotec.shared.exceptions.ApiException
import jakarta.inject.Singleton

@Singleton
class ProductServiceImpl(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository
) : ProductService {
    override fun create(payload: ProductRequestDTO): ProductDetailDTO {

        val category =
            categoryRepository.findById(payload.categoryId)
                .orElseThrow { ApiException(ApiError.REGISTRY_NOT_FOUND, "category not found") }
        val product = Product(
            name = payload.name,
            minimumStock = payload.minimumStock,
            saleValue = payload.saleValue,
            category = category
        )
        productRepository.save(product)

        return ProductDetailDTO(
            category = category.name,
            id = product.id,
            minimumStock = product.minimumStock,
            name = product.name,
            saleValue = product.saleValue
        )

    }

    override fun getById(productId: Int): ProductDetailDTO {
        TODO("Not yet implemented")
    }

    override fun list(): List<ProductResumeDTO> {
        TODO("Not yet implemented")
    }
}