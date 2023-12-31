package br.com.rspinfotec.domain.user

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "username")
    val userName: String,

    var password: String,

    @CreationTimestamp
    @Column(columnDefinition = "WITH TIME ZONE")
    val createOn: LocalDateTime? = null,

    val enable: Boolean = true


)
