package br.com.rspinfotec.shared.security.exceptions

import io.micronaut.http.HttpStatus

class ApiException(private val apiError: ApiError, errorDetail: String, statusCode: HttpStatus) : RuntimeException() {

    constructor(apiError: ApiError) : this(apiError, apiError.errorDetail, apiError.statusCode)
    constructor(apiError: ApiError, errorDetail: String) : this(apiError, errorDetail, apiError.statusCode)
    constructor(apiError: ApiError, statusCode: HttpStatus) : this(apiError, apiError.errorDetail, statusCode)
}

