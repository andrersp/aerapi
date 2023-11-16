package br.com.rspinfotec.shared.security.exceptions

import io.micronaut.http.HttpStatus

enum class ApiError(val errorType: String, val errorDetail: String, val statusCode: HttpStatus) {
    REGISTRY_NOT_FOUND("NOT_FOUND", "registry not found", HttpStatus.NOT_FOUND)
}