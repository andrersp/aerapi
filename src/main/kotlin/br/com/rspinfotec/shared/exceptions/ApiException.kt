package br.com.rspinfotec.shared.exceptions

class ApiException(val apiError: ApiError, val errorDetail: String? = null, val statusCode: Int = 400) :
    RuntimeException() {

    constructor(apiError: ApiError) : this(apiError, apiError.errorDetail)
    constructor(apiError: ApiError, statusCode: Int) : this(apiError, apiError.errorDetail, statusCode)
}

