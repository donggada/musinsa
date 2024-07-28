package com.example.demo.dto.response.lowestPriceByBrand

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API Response")
data class LowestPriceByBrandResponse(
    val lowestPriceBrandList : LowestPriceBrand
) {
    companion object {
        fun of (lowestPriceBrandList : LowestPriceBrand) : LowestPriceByBrandResponse {
            return  LowestPriceByBrandResponse(lowestPriceBrandList)
        }

        fun fixture (lowestPriceBrandList : LowestPriceBrand = LowestPriceBrand.fixture()) : LowestPriceByBrandResponse {
            return  LowestPriceByBrandResponse(lowestPriceBrandList)
        }
    }
}


