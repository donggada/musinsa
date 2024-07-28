package com.example.demo.service

import com.example.demo.config.exception.ApiException
import com.example.demo.config.exception.ErrorCode.NOT_FOUND_CATEGORY
import com.example.demo.entity.Category
import com.example.demo.repository.category.CategoryRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CategoryDataService(
    private val categoryRepository: CategoryRepository
) {

    fun findByName(categoryName: String): Category {
        return categoryRepository.findByName(categoryName).orElseThrow() { ApiException(NOT_FOUND_CATEGORY) }
    }
}