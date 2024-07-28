package com.example.demo.repository.category

import com.example.demo.entity.Category
import java.util.*

abstract class CategoryRepository() {

    abstract fun findByName(categoryName: String): Optional<Category>

}