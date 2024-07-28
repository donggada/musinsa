package com.example.demo.dto.response.categoryPrice

import com.example.demo.entity.Product
import com.example.demo.utill.FormatPriceWithDecimalFormat
import io.swagger.v3.oas.annotations.media.Schema

data class CategoryProduct(
    @Schema(description = "브랜드", required = true, example = "A")
    val brandName: String,
    @Schema(description = "브랜드", required = true, example = "1000")
    val price : Int
) {

    fun getPrice() : String {
        return FormatPriceWithDecimalFormat.format(price)
    }

    companion object {
        fun of(product: Product): CategoryProduct {
            return CategoryProduct(brandName = product.getBrandName(), price = product.price)
        }

        fun fixture(brandName: String = "", price: Int = 0) : CategoryProduct{
            return CategoryProduct(brandName = brandName, price = price)
        }
    }
}

