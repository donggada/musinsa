package com.example.demo.service

import com.example.demo.dto.response.categoryPrice.CategoryProduct
import com.example.demo.dto.response.lowestPrice.LowestPriceProduct
import com.example.demo.dto.response.lowestPriceByBrand.LowestPriceBrand
import com.example.demo.entity.Product
import org.springframework.stereotype.Service

@Service
class ProductService {


    // 구현 1) 카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API 비지니스 로직
    fun getLowestPriceProducts(productList: List<Product>) : List<LowestPriceProduct> {
        return productList.groupBy { it.category }                                          // 1. productList 를 카테고리별로 그룹화합니다.
                .mapValues { products -> products.value.asSequence().minBy { it.price } }   // 2. 각 카테고리에서 최저가 상품을 찾습니다.
                .values.asSequence()                                                        // 3. 최저가 상품들을 LowestPriceProduct 객체로 변환합니다.
                .map { LowestPriceProduct.of(it) }                                          // 4. LowestPriceProduct 객체들을 리스트로 반환합니다.
                .toList()
    }


    // 구현 2) 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API 비지니스 로직
    fun getLowestPriceByBrand(productList: List<Product>) : LowestPriceBrand {
        return productList.groupBy { it.makeKey() }                               // 1. productList 를 makeKey() 메서드를 기준으로 그룹화합니다.
            .mapValues { groupByList -> groupByList.value.minBy { it.price } }    // 2. 각 그룹에서 최저가 상품을 찾습니다.
            .values
            .groupBy { it.brand }.values                                          // 3. 최저가 상품들을 brand 필드를 기준으로 다시 그룹화합니다.
            .asSequence()
            .filter { it.isNotEmpty() }
            .map { LowestPriceBrand.of(it) }                                      // 4. 각 브랜드에 대한 최저가 상품 리스트를 LowestPriceBrand 객체로 변환합니다.
            .minBy { it.calTotalPrice() }                                         // 5. LowestPriceBrand 객체들 중에서 총 가격(calTotalPrice())이 가장 낮은 객체를 반환합니다.

    }

    // 구현 3) 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API 비지니스 로직
    fun getCategoryPrice(productList: List<Product>) : Pair<List<CategoryProduct>, List<CategoryProduct>> {
        return Pair(
            listOf(CategoryProduct.of(productList.maxBy { it.price })),    // 1.최고가 상품들을 CategoryProduct 만들어 list 로 반환 합니다.
            listOf(CategoryProduct.of(productList.minBy { it.price }))     // 2.최저가 상품들을 CategoryProduct 만들어 list 로 반환 합니다.
        )
    }

}