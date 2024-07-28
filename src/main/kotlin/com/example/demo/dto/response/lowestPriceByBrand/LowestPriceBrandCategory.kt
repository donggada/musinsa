package com.example.demo.dto.response.lowestPriceByBrand

import com.example.demo.entity.Product
import com.example.demo.utill.FormatPriceWithDecimalFormat
import io.swagger.v3.oas.annotations.media.Schema

data class LowestPriceBrandCategory(
    @Schema(description = "카테고리", required = true, example = "상의")
    val categoryName : String,

    @Schema(description = "가격", required = true, example = "1000")
    val price: Int
) {

    fun getTotalPrice() : String {
        return FormatPriceWithDecimalFormat.format(price)
    }

    companion object {
        fun of(product: Product) : LowestPriceBrandCategory {
            return LowestPriceBrandCategory(categoryName = product.getCategoryName(), price = product.price)
        }


        fun fixture(categoryName: String = "", price: Int = 0) : LowestPriceBrandCategory {
            return LowestPriceBrandCategory(categoryName = categoryName, price = price)
        }
    }
}
