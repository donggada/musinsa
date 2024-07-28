package com.example.demo.service

import com.example.demo.config.exception.ApiException
import com.example.demo.config.exception.ErrorCode.*
import com.example.demo.dto.request.AddProductRequest
import com.example.demo.dto.request.UpdateProductRequest
import com.example.demo.entity.Brand
import com.example.demo.entity.Category
import com.example.demo.entity.Product
import com.example.demo.repository.Product.ProductRepository
import com.example.demo.repository.brand.BrandRepository
import com.example.demo.repository.category.CategoryRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrDefault

@Service
class DataService(
    private val productRepository: ProductRepository,
    private val brandRepository: BrandRepository,
    private val categoryRepository: CategoryRepository
) {

    fun getProductList() : List<Product> {
        return productRepository.getProductList()
    }

    fun getProductListByCategory(categoryName: String) : List<Product> {
        return productRepository.getProductListByCategory(categoryRepository.findByName(categoryName).orElseThrow() { ApiException(NOT_FOUND_CATEGORY) })
    }


    // 구현 4) 브랜드 및 상품을 추가 API 비지니스 로직
    @OptIn(ExperimentalStdlibApi::class)
    //@Transactional DB 적용시
    fun addProduct(request: AddProductRequest) {
        val category: Category = categoryRepository.findByName(request.categoryName).orElseThrow() { ApiException(
            NOT_FOUND_CATEGORY
        ) }

        val brand: Brand = brandRepository.findByName(request.brandName).getOrDefault(
            brandRepository.save(Brand.of(Brand.metaDateInit().size, request.brandName))
        )

        productRepository.save(Product.of(id = productRepository.findCount(), category = category, brand = brand, price = request.price))
    }

    // 구현 4) 브랜드 및 상품 업데이트 API 비지니스 로직
    //@Transactional DB 적용시
    fun updateProduct(request: UpdateProductRequest) {
        val product: Product = productRepository.findById(request.productId).orElseThrow() { ApiException(
            NOT_FOUND_PRODUCT
        ) }
        val category: Category = categoryRepository.findByName(request.categoryName).orElseThrow() { ApiException(
            NOT_FOUND_CATEGORY
        ) }

        val brand: Brand = brandRepository.findByName(request.brandName).orElseThrow() { ApiException(NOT_FOUND_BRAND) }

        product.updateProduct(category = category, brand = brand, price = request.price)
    }

    // 구현 4) 브랜드 및 상품을 삭제 API 비지니스 로직
    //@Transactional DB 적용시
    fun deleteProduct(productId: Long) {
        productRepository.delete(
            productRepository.findById(productId).orElseThrow() { ApiException(NOT_FOUND_PRODUCT) }
        )
    }
}