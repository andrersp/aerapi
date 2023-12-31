package br.com.rspinfotec.repository

import br.com.rspinfotec.domain.Product
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface ProductRepository : JpaRepository<Product, Int> {
}