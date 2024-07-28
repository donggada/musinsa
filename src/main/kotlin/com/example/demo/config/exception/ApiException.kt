package com.example.demo.config.exception

class ApiException(errorCode: ErrorCode) : RuntimeException(errorCode.message) {
    override val message: String = errorCode.message
    val code: Int = errorCode.code
}