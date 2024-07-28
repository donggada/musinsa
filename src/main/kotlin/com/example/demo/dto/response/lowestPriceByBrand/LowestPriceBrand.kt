package com.example.demo.dto.response.lowestPriceByBrand

import com.example.demo.entity.Product
import com.example.demo.utill.FormatPriceWithDecimalFormat
import io.swagger.v3.oas.annotations.media.Schema


data class LowestPriceBrand(
    @Schema(description = "브랜드", required = true, example = "A")
    val brandName: String,
    val lowestPriceBrandCategoryList : List<LowestPriceBrandCategory>
) {
   private val totalPrice : Int  = lowestPriceBrandCategoryList.sumOf { it.price }

    fun calTotalPrice() : Int {
        return totalPrice
    }

    fun getTotalPrice() : String {
        return FormatPriceWithDecimalFormat.format(totalPrice)
    }

    companion object {

        fun of(productList: List<Product>): LowestPriceBrand {
            return LowestPriceBrand(
                brandName = productList[0].getBrandName(),
                lowestPriceBrandCategoryList = productList.asSequence()
                    .map { LowestPriceBrandCategory.of(it) }
                    .toList()
            )
        }

        fun fixture(brandName: String = "", lowestPriceBrandCategoryList: List<LowestPriceBrandCategory> = emptyList()): LowestPriceBrand {
            return LowestPriceBrand(brandName = brandName, lowestPriceBrandCategoryList =lowestPriceBrandCategoryList)
        }
    }
}

