package br.com.rspinfotec.shared.exceptions

import io.micronaut.serde.annotation.Serdeable
import io.swagger.v3.oas.annotations.media.Schema

@Serdeable
data class ApiErrorMessage(
    @Schema(example = "REGISTRY_NOT_FOUND")
    val errorName: String,

    @Schema(example = "NOT_FOUND")
    val errorType: String,

    @Schema(example = "")
    var errorDetail: String
)
