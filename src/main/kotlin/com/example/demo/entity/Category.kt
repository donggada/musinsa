package com.example.demo.entity

data class Category(
    val id: Long,
    val name : String
) {
    fun isSameName(categoryName: String): Boolean {
        return name == categoryName
    }

    companion object {
        fun metaDateInit(): MutableList<Category> {
            return mutableListOf(
                Category(id = 1L, name = "상의"),
                Category(id = 2L, name = "아우터"),
                Category(id = 3L, name = "바지"),
                Category(id = 4L, name = "스니커즈"),
                Category(id = 5L, name = "가방"),
                Category(id = 6L, name = "모자"),
                Category(id = 7L, name = "양말"),
                Category(id = 8L, name = "악세서리")
            )
        }


        fun fixture(id: Long = 0L, name: String = "") : Category {
            return Category(id = id, name = name)
        }
    }
}


