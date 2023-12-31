package br.com.rspinfotec.repository

import br.com.rspinfotec.domain.Category
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface CategoryRepository : JpaRepository<Category, Int> {
    fun findByName(name: String): Category?
}