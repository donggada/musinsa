package com.example.demo.facade

import com.example.demo.dto.request.AddProductRequest
import com.example.demo.dto.request.UpdateProductRequest
import com.example.demo.dto.response.categoryPrice.CategoryPriceResponse
import com.example.demo.dto.response.lowestPrice.LowestPriceProductsResponse
import com.example.demo.dto.response.lowestPriceByBrand.LowestPriceByBrandResponse
import com.example.demo.entity.Product
import com.example.demo.service.DataService
import com.example.demo.service.ProductService
import org.springframework.stereotype.Service

@Service
class ProductFacade (
    private val dateService: DataService,
    private val productService: ProductService
)  {

    fun getProductList() : List<Product> {
        return dateService.getProductList()
    }

    // 구현 1) 카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API 비지니스 로직
    fun getLowestPriceProducts(): LowestPriceProductsResponse {
        return LowestPriceProductsResponse.of(productService.getLowestPriceProducts(dateService.getProductList()))
    }


    // 구현 2) 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API 비지니스 로직
    fun getLowestPriceByBrand(): LowestPriceByBrandResponse {
        return LowestPriceByBrandResponse.of(productService.getLowestPriceByBrand(dateService.getProductList()))
    }

    // 구현 3) 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API 비지니스 로직
    fun getCategoryPrice(categoryName: String): CategoryPriceResponse {
        dateService.getProductListByCategory(categoryName)
        return CategoryPriceResponse.of(
            categoryName = categoryName,
            pair = productService.getCategoryPrice(dateService.getProductListByCategory(categoryName))
        )
    }


    // 구현 4) 브랜드 및 상품을 추가 API 비지니스 로직
    fun addProduct(request: AddProductRequest) {
        dateService.addProduct(request)
    }

    // 구현 4) 브랜드 및 상품 업데이트 API 비지니스 로직
    fun updateProduct(request: UpdateProductRequest) {
        dateService.updateProduct(request)
    }

    // 구현 4) 브랜드 및 상품을 삭제 API 비지니스 로직
    fun deleteProduct(productId: Long) {
        dateService.deleteProduct(productId)
    }
}