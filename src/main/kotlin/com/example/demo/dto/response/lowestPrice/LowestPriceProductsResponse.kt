package com.example.demo.dto.response.lowestPrice

import com.example.demo.utill.FormatPriceWithDecimalFormat
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API  Response")
data class LowestPriceProductsResponse(
    val lowestPriceProductList: List<LowestPriceProduct>
){
    @Schema(description = "총가격", required = true, example = "2400")
    private val totalPrice: Int = lowestPriceProductList.sumOf { it.price }

    fun getTotalPrice() : String {
        return FormatPriceWithDecimalFormat.format(totalPrice)
    }

    companion object {
        fun of(lowestPriceProductList: List<LowestPriceProduct>): LowestPriceProductsResponse {
            return LowestPriceProductsResponse(lowestPriceProductList)
        }

        fun  fixture(lowestPriceProductList: List<LowestPriceProduct> = emptyList()) : LowestPriceProductsResponse{
            return LowestPriceProductsResponse(lowestPriceProductList)
        }
    }
}
