package com.example.demo.dto.response.lowestPrice

import com.example.demo.entity.Product
import com.example.demo.utill.FormatPriceWithDecimalFormat
import io.swagger.v3.oas.annotations.media.Schema

data class LowestPriceProduct(
    @Schema(description = "카테고리", required = true, example = "상의")
    val categoryName: String,

    @Schema(description = "브랜드", required = true, example = "상의")
    val brandName: String,

    @Schema(description = "가격", required = true, example = "상의")
    val price : Int,
) {

    fun getPrice() : String {
        return FormatPriceWithDecimalFormat.format(price)
    }

    companion object {
        fun of(product: Product) : LowestPriceProduct {
            return LowestPriceProduct(categoryName = product.getCategoryName(), brandName = product.getBrandName(),  price = product.price)
        }

        fun fixture(categoryName: String = "", brandName: String = "", price: Int = 0): LowestPriceProduct {
            return LowestPriceProduct(categoryName = categoryName, brandName = brandName, price = price)
        }
    }
}
