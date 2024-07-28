package com.example.demo.repository.brand

import com.example.demo.entity.Brand
import com.example.demo.entity.Category
import org.springframework.stereotype.Repository
import java.util.*


@Repository
class BrandRepositoryByInMemory: BrandRepository() {

    private val brandList: MutableList<Brand> = Brand.metaDateInit()

    override fun findByName(categoryName: String): Optional<Brand> {
        return Optional.ofNullable(brandList.find { it.isSameName(categoryName) })
    }

    override fun save(brand: Brand): Brand {
        brandList.add(brand);
        return brand
    }
}