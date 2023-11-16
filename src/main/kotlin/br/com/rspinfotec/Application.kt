package br.com.rspinfotec

import io.micronaut.runtime.Micronaut.run
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.security.SecurityScheme

@SecurityScheme(
    name = "apiKey",
    paramName = "Authorization",
    type = SecuritySchemeType.APIKEY,
    `in` = SecuritySchemeIn.HEADER
)
@OpenAPIDefinition(
    info = Info(
        title = "azulerosa",
        version = "0.0"
    ),
    security = [SecurityRequirement(name = "apiKey")]
)
object Api {
}

fun main(args: Array<String>) {
    run(*args)
}

