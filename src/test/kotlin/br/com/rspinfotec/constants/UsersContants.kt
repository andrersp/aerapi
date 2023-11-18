package br.com.rspinfotec.constants

import br.com.rspinfotec.dtos.user.UserRequestDTO
import br.com.rspinfotec.entity.User

object UsersContants {
    val USER_PAYLOAD = UserRequestDTO(userName = "testeUser", password = "admin")
    val USER_1 = User(
        id = 1L,
        userName = "testeUser",
        password = "\$2a\$10\$JTw1DDUAAJ4WenZctgPujui0oF3goyW2zygXtyH0Mk.9g6w6x67ie",
        enable = true
    )
    val USERS = listOf(USER_1)
}