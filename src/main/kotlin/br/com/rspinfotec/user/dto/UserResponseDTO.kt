package br.com.rspinfotec.user.dto

import br.com.rspinfotec.user.User
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class UserResponseDTO(
    val id: Long? = null,
    val userName: String? = null,
    val enable: Boolean? = null
) {
    companion object {
        fun fromDomain(user: User) = UserResponseDTO(
            id = user.id,
            userName = user.userName,
            enable = user.enable
        )
    }
}

