package com.example.demo.controller

import com.example.demo.dto.request.AddProductRequest
import com.example.demo.dto.request.UpdateProductRequest
import com.example.demo.dto.response.categoryPrice.CategoryPriceResponse
import com.example.demo.dto.response.lowestPrice.LowestPriceProductsResponse
import com.example.demo.dto.response.lowestPriceByBrand.LowestPriceByBrandResponse
import com.example.demo.entity.Product
import com.example.demo.facade.ProductFacade
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController(
    private val productFacade: ProductFacade
) {

    @Operation(summary = "전체 조회 API")
    @GetMapping("/all")
    fun all(): List<Product> {
        return productFacade.getProductList()
    }


    @Operation(summary = "카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API")
    @GetMapping("/lowest-price")
    fun getLowestPriceProducts(): LowestPriceProductsResponse {
        return productFacade.getLowestPriceProducts()
    }

    @Operation(summary = "단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API")
    @GetMapping("/lowest-brand")
    fun getLowestPriceByBrand(): LowestPriceByBrandResponse {
        return productFacade.getLowestPriceByBrand()
    }

    @Operation(summary = "카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API")
    @GetMapping("/category-price")
    fun getCategoryPrice(@RequestParam categoryName: String): CategoryPriceResponse {
        return productFacade.getCategoryPrice(categoryName)
    }

    @Operation(summary = "브랜드 및 상품을 추가 API")
    @PostMapping("")
    fun addProduct(@RequestBody request: AddProductRequest): ResponseEntity<String> {
        productFacade.addProduct(request)
        return ResponseEntity.ok("Product add successfully")
    }

    @Operation(summary = "브랜드 및 상품을 업데이트 API")
    @PatchMapping("")
    fun updateProduct(@RequestBody request: UpdateProductRequest): ResponseEntity<String> {
        productFacade.updateProduct(request)
        return ResponseEntity.ok("Product updated successfully")
    }

    @Operation(summary = "브랜드 및 상품을 삭제 API")
    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Long): ResponseEntity<String> {
        productFacade.deleteProduct(id)
        return ResponseEntity.ok("Product deleted successfully")
    }
}