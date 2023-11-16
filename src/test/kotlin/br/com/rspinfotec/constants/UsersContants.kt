package br.com.rspinfotec.constants

import br.com.rspinfotec.entity.User

object UsersContants {
    val USER_1 = User(id = 1L, userName = "testeUser", password = "user123")
    val USERS = listOf(USER_1,)
}