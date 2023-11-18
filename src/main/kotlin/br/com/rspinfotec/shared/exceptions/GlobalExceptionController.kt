package br.com.rspinfotec.shared.exceptions

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Error
import io.micronaut.security.authentication.AuthorizationException
import jakarta.validation.ConstraintViolationException

@Controller
class GlobalExceptionController {
    @Error(global = true)
    fun handlerApiException(request: HttpRequest<*>, exc: ApiException): HttpResponse<ApiErrorMessage> {
        val errorMessage = ApiError.getErrorMessageApiException(exc)
        return HttpResponse.serverError(errorMessage).status(exc.statusCode)

    }

    @Error(global = true)
    fun authorizationError(request: HttpRequest<*>, exc: AuthorizationException): HttpResponse<ApiErrorMessage> {
        val err = ApiError.getErrorMessageException(ApiError.UNAUTHORIZED)
        return HttpResponse.serverError(err).status(HttpStatus.UNAUTHORIZED)
    }

    @Error(global = true)
    fun duplicateValueError(request: HttpRequest<*>, exc: ConstraintViolationException): HttpResponse<ApiErrorMessage> {
        val err = ApiError.getErrorMessageException(ApiError.INVALID_PAYLOAD, exc)
        return HttpResponse.serverError(err).status(HttpStatus.UNPROCESSABLE_ENTITY)
    }

    @Error(global = true)
    fun handlerGlobalError(
        request: HttpRequest<*>,
        exc: Exception
    ): HttpResponse<ApiErrorMessage> {
        val err = ApiError.getErrorMessageException(ApiError.GENERIC_ERROR)
        return HttpResponse.serverError(err).status(HttpStatus.BAD_REQUEST)
    }


}