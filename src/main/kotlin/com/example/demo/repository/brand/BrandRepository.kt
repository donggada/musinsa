package com.example.demo.repository.brand

import com.example.demo.entity.Brand
import com.example.demo.entity.Category
import java.util.*

abstract class BrandRepository() {

    abstract fun findByName(categoryName: String): Optional<Brand>


    abstract fun save(brand: Brand) : Brand

}