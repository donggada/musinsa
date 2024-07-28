package com.example.demo.entity

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BrandTest {

    @Test
    fun isSameNameResultTrue() {
        assertThat(Brand.fixture(name = "testBrand").isSameName("testBrand")).isTrue()
    }

    @Test
    fun isSameNameResultFalse() {
        assertThat(Brand.fixture(name = "testBrand").isSameName("testBrand1")).isFalse()
    }
}