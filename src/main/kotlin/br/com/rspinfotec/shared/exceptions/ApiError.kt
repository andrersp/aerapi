package br.com.rspinfotec.shared.exceptions

enum class ApiError(val errorType: String, val errorDetail: String) {
    REGISTRY_NOT_FOUND("NOT_FOUND", "registry not found"),
    DUPLICATE_REGISTRY("DUPLICATE", "registry existing"),
    INVALID_AUTHENTICATION("AUTHENTICATION", "invalid user or password"),
    UNAUTHORIZED("AUTHORIZATION", "Unauthorized access"),
    INVALID_TOKEN("AUTHORIZATION", "Invalid token"),
    INVALID_PAYLOAD("VALIDATION", "invalid param or data in payload"),
    GENERIC_ERROR("GENERIC", "generic error")
    ;

    companion object {
        fun getErrorMessageException(apiError: ApiError, exc: Exception? = null): ApiErrorMessage {
            val errorDetail = exc.takeIf { it != null }
                ?.localizedMessage
                ?: apiError.errorDetail
            return ApiErrorMessage(
                errorName = apiError.name,
                errorType = apiError.errorType,
                errorDetail = errorDetail
            )
        }

        fun getErrorMessageApiException(exc: ApiException): ApiErrorMessage {
            val err = exc.apiError
            val errorDetail = exc.takeIf { exc.errorDetail != null }
                ?.errorDetail
                ?: err.errorDetail
            return ApiErrorMessage(
                errorName = err.name,
                errorType = err.errorType,
                errorDetail = errorDetail
            )
        }


    }
}