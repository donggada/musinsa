package com.example.demo.config.exception

enum class ErrorCode(val code: Int, val message: String) {
    UNKNOWN_ERROR(9999, "확인되지 않은 오류입니다."),
    NOT_FOUND_CATEGORY(404, "클라이언트가 요청한 카테고리가 존재하지 않습니다."),
    NOT_FOUND_PRODUCT(404, "클라이언트가 요청한 상품이 존재하지 않습니다."),
    NOT_FOUND_BRAND(404, "클라이언트가 요청한 브랜드가 존재하지 않습니다."),
    INTERNAL_SERVER_ERROR(500, "서버 에러가 발생했습니다."),
}