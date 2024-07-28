package com.example.demo.entity

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProductTest {

    @Test
    fun isSameCategory() {
        assertThat(
            Product.fixture(
                category = Category.fixture(id = 1L, name = "test")
            ).isSameCategory(
                    Category.fixture(
                        id = 1L,
                        name = "test"
                    )
                )
        ).isTrue()
    }

    @Test
    fun isSameId() {
        assertThat(Product.fixture(1L).isSameId(1L)).isTrue()
    }

    @Test
    fun updateProduct() {
        val beforeCategory : Category = Category.fixture(id = 1L, name = "beforeCategory")
        val beforeBrand : Brand = Brand.fixture(id = 1L, name = "beforeBrand")
        val beforePrice : Int = 5000

        val afterCategory : Category = Category.fixture(id = 1L, name = "afterCategory")
        val afterCBrand : Brand = Brand.fixture(id = 1L, name = "afterBrand")
        val afterCPrice : Int = 1000

        val product: Product = Product.fixture(id = 2L, category = beforeCategory, brand = beforeBrand, price = beforePrice)

        product.updateProduct(category = afterCategory, brand = afterCBrand, price = afterCPrice)

        assertThat(
            product == Product.fixture(id = 2L, category = afterCategory, brand = afterCBrand, price = afterCPrice)
        ).isTrue()
    }
}