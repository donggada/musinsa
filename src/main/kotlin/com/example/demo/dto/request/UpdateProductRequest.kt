package com.example.demo.dto.request

import io.swagger.v3.oas.annotations.media.Schema
@Schema(description = "브랜드 및 상품을 업데이트 API  로직 API Request")
data class UpdateProductRequest(
    @Schema(description = "상품 아이디", required = true, example = "1")
    val productId: Long,

    @Schema(description = "브랜드", required = true, example = "A")
    val brandName : String,

    @Schema(description = "카테고리", required = true, example = "상의")
    val categoryName: String,

    @Schema(description = "가격", required = true, example = "1000")
    val price: Int
)
