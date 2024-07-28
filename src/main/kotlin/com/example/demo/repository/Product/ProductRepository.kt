package com.example.demo.repository.Product

import com.example.demo.entity.Category
import com.example.demo.entity.Product
import java.util.Optional

abstract class ProductRepository() {
    // DB 로 변경 가능하도록 추상화

    abstract fun getProductList() : List<Product>

    abstract fun getProductListByCategory(category: Category) : List<Product>

    abstract fun save(product: Product) : Product

    abstract fun findById(id: Long) : Optional<Product>

    abstract fun delete(product: Product)

    abstract fun findCount() : Int
}