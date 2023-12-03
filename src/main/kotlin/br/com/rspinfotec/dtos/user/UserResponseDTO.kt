package br.com.rspinfotec.dtos.user

import br.com.rspinfotec.domain.user.User
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

