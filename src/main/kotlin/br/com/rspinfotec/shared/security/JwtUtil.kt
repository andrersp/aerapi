package br.com.rspinfotec.shared.security

import br.com.rspinfotec.shared.exceptions.ApiError
import br.com.rspinfotec.shared.exceptions.ApiException
import com.nimbusds.jose.JWSAlgorithm
import com.nimbusds.jose.JWSHeader
import com.nimbusds.jose.crypto.MACSigner
import com.nimbusds.jose.crypto.MACVerifier
import com.nimbusds.jwt.JWTClaimsSet
import com.nimbusds.jwt.SignedJWT
import io.micronaut.context.annotation.Value
import jakarta.inject.Singleton
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*

@Singleton
class JwtUtil {

    @Value("\${security.jwt_secret}")
    private lateinit var jwtSecret: String

    fun generateJwtToken(userId: Long, userName: String): String {
        val signer = MACSigner(jwtSecret.toByteArray())
        val claims = JWTClaimsSet.Builder()
            .expirationTime(Date.from(Instant.now().plus(600, ChronoUnit.SECONDS)))
            .claim("userName", userName)
            .claim("id", userId)
            .build()
        val signedJWT = SignedJWT(JWSHeader(JWSAlgorithm.HS256), claims)
        signedJWT.sign(signer)
        return signedJWT.serialize()
    }

    fun validateJwtToken(accessToken: String): String {

        val jwt: SignedJWT
        try {
            jwt = SignedJWT.parse(accessToken)
        } catch (_: Exception) {
            throw ApiException(ApiError.INVALID_TOKEN, 401)
        }

        val verify = MACVerifier(jwtSecret.toByteArray())
        if (!jwt.verify(verify)) throw ApiException(ApiError.INVALID_TOKEN, 401)
        val claims = jwt.jwtClaimsSet
        return claims.getClaim("userName").toString()
    }
}