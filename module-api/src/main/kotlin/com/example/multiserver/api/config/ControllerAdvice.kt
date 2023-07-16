package com.example.multiserver.api.config

import com.example.multiserver.api.dto.response.ErrorResponse
import com.example.multiserver.exception.BadRequestException
import com.example.multiserver.exception.ErrorType
import com.example.multiserver.util.Logger.logger
import javax.servlet.http.HttpServletRequest
import org.hibernate.exception.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.HttpStatusCodeException
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.multipart.MaxUploadSizeExceededException
import org.springframework.web.multipart.support.MissingServletRequestPartException

@RestControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(
        value = [
            NoSuchElementException::class
        ]
    )
    fun handleNotFoundException(
        request: HttpServletRequest,
        e: NoSuchElementException,
    ): ResponseEntity<ErrorResponse> {
        logger.warn("${request.requestURL} \nhandleNotFoundException:${e.message}")
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ErrorResponse(ErrorType.NOT_FOUND.message))
    }

    @ExceptionHandler(
        value = [
            BadRequestException::class,
            MaxUploadSizeExceededException::class
        ]
    )
    fun handleBadRequestException(
        request: HttpServletRequest,
        e: Exception,
    ): ResponseEntity<ErrorResponse> {
        logger.warn("${request.requestURL} \nhandleBadRequestException:${e.message}")
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponse(ErrorType.BAD_REQUEST.message))
    }

    @ExceptionHandler(
        value = [
            HttpServerErrorException::class,
            HttpClientErrorException::class,
        ]
    )
    fun handleRestClientException(
        request: HttpServletRequest,
        e: HttpStatusCodeException,
    ): ResponseEntity<ErrorResponse> {
        logger.warn("${request.requestURL} \nhandleRestClientException:${e.message}")
        return ResponseEntity
            .status(e.statusCode)
            .body(ErrorResponse(e.message ?: "Unknown Error"))
    }



    @ExceptionHandler(
        value = [
            HttpMessageNotReadableException::class,
            MethodArgumentNotValidException::class,
            ConstraintViolationException::class,
            MissingServletRequestParameterException::class,
            MissingServletRequestPartException::class,
            IllegalArgumentException::class,
            MethodArgumentTypeMismatchException::class,
            javax.validation.ConstraintViolationException::class
        ]
    )
    fun handleBindBadRequest(
        request: HttpServletRequest,
        e: Exception,
    ): ResponseEntity<ErrorResponse> {
        logger.warn("${request.requestURL} \nhandleBindBadRequest:${e.message}")

        val errorMessage = when (e) {
            is MethodArgumentNotValidException -> {
                val fieldErrors = e.bindingResult.fieldErrors
                fieldErrors.stream()
                    .map { fieldError -> fieldError.field + "는 " + fieldError.defaultMessage }
                    .reduce { a, b -> "$a $b" }
                    .orElse(e.message)
            }

            is MissingServletRequestParameterException -> {
                val missingParameter = e.parameterName
                String.format("필수 파라미터가 누락되었습니다. (%s)", missingParameter)
            }

            is HttpMessageNotReadableException -> {
                "required request body is missing"
            }

            else -> e.message
        }

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(
                ErrorResponse(
                    errorMessage = errorMessage ?: ErrorType.BAD_REQUEST.message,
                )
            )
    }

    @ExceptionHandler(value = [Exception::class])
    fun handleUnexpectedException(request: HttpServletRequest, e: Exception): ResponseEntity<ErrorResponse> {
        logger.error(
            "${request.requestURL} \nhandleUnexpectedException: ${e.message}\nSTACK_TRACE: ${e.stackTrace.slice(0..10)}\n"
        )
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(
                ErrorResponse(
                    errorMessage = e.toErrorMessage(ErrorType.ETC_UNKNOWN_ERROR)
                )
            )
    }

    private fun Exception.toErrorMessage(errorType: ErrorType? = null): String {
        return localizedMessage ?: errorType?.message ?: ""
    }
}
