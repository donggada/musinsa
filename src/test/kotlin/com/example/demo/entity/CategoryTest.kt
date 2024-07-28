package com.example.demo.entity

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CategoryTest {

    @Test
    fun isSameName() {
        val categoryName : String = "test"
        Assertions.assertThat(
            Category.fixture(name = categoryName).isSameName(categoryName)
        ).isTrue()
    }
}