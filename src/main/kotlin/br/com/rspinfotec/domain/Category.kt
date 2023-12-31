package br.com.rspinfotec.domain

import jakarta.persistence.*

@Entity
@Table(name = "categories")
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(nullable = false, length = 100, unique = true)
    var name: String,

    @OneToMany(mappedBy = "category", orphanRemoval = false, fetch = FetchType.LAZY)
    var products: MutableList<Product> = mutableListOf()
)
