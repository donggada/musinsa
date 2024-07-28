package com.example.demo.dto.response.categoryPrice

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API Response")
data class CategoryPriceResponse(
    @Schema(description = "카테고리", required = true, example = "상의")
    val categoryName: String,
    val lowPriceProductList : List<CategoryProduct>,
    val highPriceProductList : List<CategoryProduct>
) {
    companion object {
        fun of(categoryName: String, pair: Pair<List<CategoryProduct>,List<CategoryProduct>>) : CategoryPriceResponse{
            return CategoryPriceResponse(
                categoryName = categoryName,
                highPriceProductList = pair.first,
                lowPriceProductList = pair.second
            )
        }

        fun fixture(categoryName: String = "",
                    highPriceProductList: List<CategoryProduct> = emptyList(),
                    lowPriceProductList : List<CategoryProduct> = emptyList()) : CategoryPriceResponse{
            return CategoryPriceResponse(
                categoryName = categoryName,
                highPriceProductList = highPriceProductList,
                lowPriceProductList = lowPriceProductList
            )
        }
    }
}