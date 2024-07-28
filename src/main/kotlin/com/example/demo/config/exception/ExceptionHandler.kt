package com.example.demo.config.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.*

@RestControllerAdvice
class ExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception::class)
    fun commonExceptionHandler(e: Exception): ResponseEntity<ErrorResponse> {
        val traceId = System.currentTimeMillis().toString() + UUID.randomUUID().toString().substring(0, 8)
        return ResponseEntity.internalServerError().body(ErrorResponse(ErrorCode.UNKNOWN_ERROR, traceId))
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ApiException::class)
    fun customExceptionHandler(e: ApiException): ResponseEntity<ErrorResponse> {
        val traceId = System.currentTimeMillis().toString() + UUID.randomUUID().toString().substring(0, 8)
        return ResponseEntity.badRequest().body(ErrorResponse(e, traceId))
    }
}