package com.example.demo.facade

import com.example.demo.dto.response.categoryPrice.CategoryPriceResponse
import com.example.demo.dto.response.categoryPrice.CategoryProduct
import com.example.demo.dto.response.lowestPrice.LowestPriceProduct
import com.example.demo.dto.response.lowestPrice.LowestPriceProductsResponse
import com.example.demo.dto.response.lowestPriceByBrand.LowestPriceBrand
import com.example.demo.dto.response.lowestPriceByBrand.LowestPriceBrandCategory
import com.example.demo.dto.response.lowestPriceByBrand.LowestPriceByBrandResponse
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductFacadeTest(
    @Autowired
    private val productFacade: ProductFacade
) {

    @Test
    fun getLowestPriceProducts() {
        val lowestPriceProducts : LowestPriceProductsResponse = productFacade.getLowestPriceProducts()
        assertThat(lowestPriceProducts).isEqualTo(
            LowestPriceProductsResponse.fixture(
                listOf(
                    LowestPriceProduct.fixture(categoryName = "상의", brandName = "C", price = 10000),
                    LowestPriceProduct.fixture(categoryName = "아우터", brandName = "E", price = 5000),
                    LowestPriceProduct.fixture(categoryName = "바지", brandName = "D", price = 3000),
                    LowestPriceProduct.fixture(categoryName = "스니커즈", brandName = "A", price = 9000),
                    LowestPriceProduct.fixture(categoryName = "가방", brandName = "A", price = 2000),
                    LowestPriceProduct.fixture(categoryName = "모자", brandName = "D", price = 1500),
                    LowestPriceProduct.fixture(categoryName = "양말", brandName = "I", price = 1700),
                    LowestPriceProduct.fixture(categoryName = "악세서리", brandName = "F", price = 1900),
                )
            )
        )

        assertThat(lowestPriceProducts.getTotalPrice()).isEqualTo("34,100")

    }

    @Test
    fun getLowestPriceByBrand() {
        val lowestPriceByBrand = productFacade.getLowestPriceByBrand()
        assertThat(lowestPriceByBrand).isEqualTo(
            LowestPriceByBrandResponse.fixture(
                LowestPriceBrand.fixture(
                    brandName = "D",
                    lowestPriceBrandCategoryList = listOf(
                        LowestPriceBrandCategory.fixture(categoryName = "상의", price = 10100),
                        LowestPriceBrandCategory.fixture(categoryName = "아우터", price = 5100),
                        LowestPriceBrandCategory.fixture(categoryName = "바지", price = 3000),
                        LowestPriceBrandCategory.fixture(categoryName = "스니커즈", price = 9500),
                        LowestPriceBrandCategory.fixture(categoryName = "가방", price = 2500),
                        LowestPriceBrandCategory.fixture(categoryName = "모자", price = 1500),
                        LowestPriceBrandCategory.fixture(categoryName = "양말", price = 2400),
                        LowestPriceBrandCategory.fixture(categoryName = "악세서리", price = 2000),
                    )
                )
            )
        )
    }

    @Test
    fun getCategoryPrice() {
        assertThat(productFacade.getCategoryPrice("상의")).isEqualTo(
            CategoryPriceResponse.fixture(
                categoryName = "상의",
                highPriceProductList = listOf(CategoryProduct.fixture("I", 11400)),
                lowPriceProductList = listOf(CategoryProduct.fixture("C", 10000)),
            )
        )
    }
}