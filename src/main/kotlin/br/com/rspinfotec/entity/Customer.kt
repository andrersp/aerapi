package br.com.rspinfotec.entity

import jakarta.persistence.*

@Entity
@Table(name = "customers")
data class Customer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, length = 255)
    var name: String,

    @Column(nullable = false, length = 14, unique = true)
    var phone: String,

    @Column(length = 255)
    var obs: String
)
