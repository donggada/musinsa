package com.example.demo.repository.Product

import com.example.demo.entity.Category
import com.example.demo.entity.Product
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ProductRepositoryByInMemory: ProductRepository() {

    private val productList: MutableList<Product> = Product.metaDateInit()

    override fun getProductList(): List<Product> {
        return productList
    }



    override fun getProductListByCategory(category: Category): List<Product> {
        return productList.asSequence()
            .filter { it.isSameCategory(category) }
            .toList()
    }

    override fun findCount(): Int {
        return productList.size
    }

    override fun save(product: Product): Product {
        productList.add(product)
        return product
    }

    override fun findById(id: Long): Optional<Product> {
        return Optional.ofNullable(productList.find { it.isSameId(id) })
    }

    override fun delete(product: Product) {
        productList.remove(product)
    }
}