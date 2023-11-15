package br.com.rspinfotec.shared.security

import org.mindrot.jbcrypt.BCrypt

object PasswordEncoder {
    fun hashPassword(plainPassword: String): String =
        BCrypt.hashpw(plainPassword, BCrypt.gensalt())

    fun checkPassword(plainPassword: String, hashedPassword: String): Boolean =
        BCrypt.checkpw(plainPassword, hashedPassword)
}