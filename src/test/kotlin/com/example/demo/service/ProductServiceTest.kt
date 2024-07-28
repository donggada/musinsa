package com.example.demo.service

import com.example.demo.dto.response.categoryPrice.CategoryProduct
import com.example.demo.dto.response.lowestPrice.LowestPriceProduct
import com.example.demo.dto.response.lowestPriceByBrand.LowestPriceBrand
import com.example.demo.dto.response.lowestPriceByBrand.LowestPriceBrandCategory
import com.example.demo.entity.Brand
import com.example.demo.entity.Category
import com.example.demo.entity.Product
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ProductServiceTest {

    private val productService : ProductService = ProductService()
    private val productList: MutableList<Product> = Product.metaDateInit()

    @Test
    @DisplayName("카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API 비지니스 로직")
    fun getLowestPriceProducts() {
        assertThat(
            productService.getLowestPriceProducts(productList)
        ).containsExactlyElementsOf(
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
    }

    @Test
    @DisplayName("단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API 비지니스 로직")
    fun getLowestPriceByBrand() {
        val lowestPriceByBrand: LowestPriceBrand = productService.getLowestPriceByBrand(productList)

        assertThat(
            lowestPriceByBrand
        ).isEqualTo(
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

        assertThat(lowestPriceByBrand.calTotalPrice()).isEqualTo(36100)
        assertThat(lowestPriceByBrand.getTotalPrice()).isEqualTo("36,100")

    }

    @Test
    @DisplayName("단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API 비지니스 로직")
    fun getLowestPriceByBrandWhen() {
        productList.add(Product.fixture(brand = Brand.fixture(id = 4L, name = "D"), category = Category.fixture(id = 1L, name = "상의"), price = 9100),)
        val lowestPriceByBrand: LowestPriceBrand = productService.getLowestPriceByBrand(productList)
        assertThat(
            lowestPriceByBrand
        ).isEqualTo(
            LowestPriceBrand.fixture(
                brandName = "D",
                lowestPriceBrandCategoryList = listOf(
                    LowestPriceBrandCategory.fixture(categoryName = "상의", price = 9100),
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
        assertThat(lowestPriceByBrand.calTotalPrice()).isEqualTo(35100)
        assertThat(lowestPriceByBrand.getTotalPrice()).isEqualTo("35,100")
    }

    @Test
    @DisplayName("같은 카테고리 상품의 최저, 최고 가격 브랜드와 상품 가격 조회 로직 (각각 다른 브랜드 일 경우)")
    fun getCategoryPrice() {
        assertThat(
            productService.getCategoryPrice(
                listOf(
                    Product.fixture(brand = Brand.fixture(name = "A"), category = Category.fixture(name = "상의"), price = 1000),
                    Product.fixture(brand = Brand.fixture(name = "B"), category = Category.fixture(name = "상의"), price = 3000),
                    Product.fixture(brand = Brand.fixture(name = "C"), category = Category.fixture(name = "상의"), price = 4000),
                )
            )
        ).isEqualTo(
            Pair(
                listOf(CategoryProduct.fixture(brandName = "C", price = 4000)),
                listOf(CategoryProduct.fixture(brandName = "A", price = 1000))
            )
        )

    }

    @Test
    @DisplayName("같은 카테고리 상품의 최저, 최고 가격 브랜드와 상품 가격 조회 로직 (두개가 같은 브랜드 일 경우)")
    fun getCategoryPriceWhenTwoSameBrand() {
        assertThat(
            productService.getCategoryPrice(
                listOf(
                    Product.fixture(brand = Brand.fixture(name = "A"), category = Category.fixture(name = "상의"), price = 1000),
                    Product.fixture(brand = Brand.fixture(name = "B"), category = Category.fixture(name = "상의"), price = 3000),
                    Product.fixture(brand = Brand.fixture(name = "A"), category = Category.fixture(name = "상의"), price = 4000),
                )
            )
        ).isEqualTo(
            Pair(
                listOf(CategoryProduct.fixture(brandName = "A", price = 4000)),
                listOf(CategoryProduct.fixture(brandName = "A", price = 1000))
            )
        )

    }
}