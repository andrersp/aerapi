package br.com.rspinfotec.shared.security

import io.micronaut.core.async.publisher.Publishers
import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.Authentication
import io.micronaut.security.token.validator.TokenValidator
import jakarta.inject.Singleton
import org.reactivestreams.Publisher

@Singleton
class TokenValidator(private val jwtUtil: JwtUtil): TokenValidator<HttpRequest<*>> {
    override fun validateToken(token: String?, request: HttpRequest<*>?): Publisher<Authentication> {
        if (token == null) throw  Exception("Invaid Token")
        return try {
            val username = jwtUtil.validateJwtToken(token)
            Publishers.just(Authentication.build(username))
        } catch (exc: Exception) {
            Publishers.just(exc)

        }

    }
}