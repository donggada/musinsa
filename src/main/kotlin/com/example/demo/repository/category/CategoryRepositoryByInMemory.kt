package com.example.demo.repository.category

import com.example.demo.entity.Category
import org.springframework.stereotype.Repository
import java.util.*


@Repository
class CategoryRepositoryByInMemory: CategoryRepository() {

    private val categoryList: MutableList<Category> = Category.metaDateInit()

    override fun findByName(categoryName: String): Optional<Category> {
        return Optional.ofNullable(categoryList.find { it.isSameName(categoryName) })
    }
}