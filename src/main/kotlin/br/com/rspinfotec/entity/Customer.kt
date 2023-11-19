package br.com.rspinfotec.entity

import jakarta.persistence.*

@Entity
@Table(name = "customers")
data class Customer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, length = 255)
    val name: String,

    @Column(nullable = false, length = 14, unique = true)
    val phone: String,

    @Column(length = 255)
    val obs: String
)
