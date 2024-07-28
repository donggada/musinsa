package com.example.demo.config.exception

import io.swagger.v3.oas.annotations.media.Schema

class ErrorResponse (
    val code: Int,
    @Schema(description = "에러 메시지", required = true, example = "에러 메시지")
    val message: String,
    @Schema(description = "traceId", required = true, example = "1675388839117047ee87d")
    val traceId: String
) {
    constructor(errorCode: ErrorCode, traceId: String) : this(errorCode.code, errorCode.message, traceId)

    constructor(e: ApiException, traceId: String) : this(e.code, e.message, traceId)
}