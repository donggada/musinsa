package com.example.demo.entity

data class Product(
    val id : Long,
    var brand : Brand,
    var category : Category,
    var price: Int
) {

    fun getCategoryName() : String {
        return category.name
    }

    fun getBrandName() : String {
        return brand.name
    }

    fun isSameCategory(category: Category): Boolean {
        return this.category == category
    }

    fun isSameId(id: Long): Boolean {
        return this.id == id
    }

    fun makeKey (): String {
        return getBrandName() + getCategoryName()
    }


    fun updateProduct(category: Category, brand: Brand, price: Int) {
        this.category = category
        this.brand = brand
        this.price = price
    }

    companion object{
        fun of (category: Category, brand: Brand, price: Int, id : Int): Product {
            return Product(category = category, brand = brand, price = price, id = id + 1L)
        }

        fun fixture(id: Long = 0L, category: Category = Category.fixture(), brand: Brand = Brand.fixture(), price: Int = 0): Product{
            return Product(id = id, brand = brand, category = category, price = price)
        }

      fun metaDateInit() : MutableList<Product> {
          val Abrand = Brand(id = 1L, name = "A")
          val Bbrand = Brand(id = 2L, name = "B")
          val Cbrand = Brand(id = 3L, name = "C")
          val Dbrand = Brand(id = 4L, name = "D")
          val Ebrand = Brand(id = 5L, name = "E")
          val Fbrand = Brand(id = 6L, name = "F")
          val Gbrand = Brand(id = 7L, name = "G")
          val Hbrand = Brand(id = 8L, name = "H")
          val Ibrand = Brand(id = 9L, name = "I")

          val top = Category(id = 1L, name = "상의")
          val outer = Category(id = 2L, name = "아우터")
          val bottom = Category(id = 3L, name = "바지")
          val sneakers = Category(id = 4L, name = "스니커즈")
          val bag = Category(id = 5L, name = "가방")
          val hat = Category(id = 6L, name = "모자")
          val socks = Category(id = 7L, name = "양말")
          val acc = Category(id = 8L, name = "악세서리")


          return mutableListOf(
              Product(id = 1L, brand = Abrand, category = top, price = 11200),
              Product(id = 2L, brand = Bbrand, category = top, price = 10500),
              Product(id = 3L, brand = Cbrand, category = top, price = 10000),
              Product(id = 4L, brand = Dbrand, category = top, price = 10100),
              Product(id = 5L, brand = Ebrand, category = top, price = 10700),
              Product(id = 6L, brand = Fbrand, category = top, price = 11200),
              Product(id = 7L, brand = Gbrand, category = top, price = 10500),
              Product(id = 8L, brand = Hbrand, category = top, price = 10800),
              Product(id = 9L, brand = Ibrand, category = top, price = 11400),

              Product(id = 10L, brand = Abrand, category = outer, price = 5500),
              Product(id = 11L, brand = Bbrand, category = outer, price = 5900),
              Product(id = 12L, brand = Cbrand, category = outer, price = 6200),
              Product(id = 13L, brand = Dbrand, category = outer, price = 5100),
              Product(id = 14L, brand = Ebrand, category = outer, price = 5000),
              Product(id = 15L, brand = Fbrand, category = outer, price = 7200),
              Product(id = 16L, brand = Gbrand, category = outer, price = 5800),
              Product(id = 17L, brand = Hbrand, category = outer, price = 6300),
              Product(id = 18L, brand = Ibrand, category = outer, price = 6700),

              Product(id = 19L, brand = Abrand, category = bottom, price = 4200),
              Product(id = 20L, brand = Bbrand, category = bottom, price = 3800),
              Product(id = 21L, brand = Cbrand, category = bottom, price = 3300),
              Product(id = 22L, brand = Dbrand, category = bottom, price = 3000),
              Product(id = 23L, brand = Ebrand, category = bottom, price = 3800),
              Product(id = 24L, brand = Fbrand, category = bottom, price = 4000),
              Product(id = 25L, brand = Gbrand, category = bottom, price = 3900),
              Product(id = 26L, brand = Hbrand, category = bottom, price = 3100),
              Product(id = 27L, brand = Ibrand, category = bottom, price = 3200),

              Product(id = 28L, brand = Abrand, category = sneakers, price = 9000),
              Product(id = 29L, brand = Bbrand, category = sneakers, price = 9100),
              Product(id = 30L, brand = Cbrand, category = sneakers, price = 9200),
              Product(id = 31L, brand = Dbrand, category = sneakers, price = 9500),
              Product(id = 32L, brand = Ebrand, category = sneakers, price = 9900),
              Product(id = 33L, brand = Fbrand, category = sneakers, price = 9300),
              Product(id = 34L, brand = Gbrand, category = sneakers, price = 9000),
              Product(id = 35L, brand = Hbrand, category = sneakers, price = 9700),
              Product(id = 36L, brand = Ibrand, category = sneakers, price = 9500),

              Product(id = 37L, brand = Abrand, category = bag, price = 2000),
              Product(id = 38L, brand = Bbrand, category = bag, price = 2100),
              Product(id = 39L, brand = Cbrand, category = bag, price = 2200),
              Product(id = 40, brand = Dbrand, category = bag, price = 2500),
              Product(id = 41L, brand = Ebrand, category = bag, price = 2300),
              Product(id = 42L, brand = Fbrand, category = bag, price = 2100),
              Product(id = 43L, brand = Gbrand, category = bag, price = 2200),
              Product(id = 44L, brand = Hbrand, category = bag, price = 2100),
              Product(id = 45L, brand = Ibrand, category = bag, price = 2400),

              Product(id = 46L, brand = Abrand, category = hat, price = 1700),
              Product(id = 47L, brand = Bbrand, category = hat, price = 2000),
              Product(id = 48L, brand = Cbrand, category = hat, price = 1900),
              Product(id = 49L, brand = Dbrand, category = hat, price = 1500),
              Product(id = 50L, brand = Ebrand, category = hat, price = 1800),
              Product(id = 51L, brand = Fbrand, category = hat, price = 1600),
              Product(id = 52L, brand = Gbrand, category = hat, price = 1700),
              Product(id = 53L, brand = Hbrand, category = hat, price = 1600),
              Product(id = 54L, brand = Ibrand, category = hat, price = 1700),

              Product(id = 55L, brand = Abrand, category = socks, price = 1800),
              Product(id = 56L, brand = Bbrand, category = socks, price = 2000),
              Product(id = 57L, brand = Cbrand, category = socks, price = 2200),
              Product(id = 58L, brand = Dbrand, category = socks, price = 2400),
              Product(id = 59L, brand = Ebrand, category = socks, price = 2100),
              Product(id = 60L, brand = Fbrand, category = socks, price = 2300),
              Product(id = 61L, brand = Gbrand, category = socks, price = 2100),
              Product(id = 62L, brand = Hbrand, category = socks, price = 2000),
              Product(id = 63L, brand = Ibrand, category = socks, price = 1700),

              Product(id = 64L, brand = Abrand, category = acc, price = 2300),
              Product(id = 65L, brand = Bbrand, category = acc, price = 2200),
              Product(id = 66L, brand = Cbrand, category = acc, price = 2100),
              Product(id = 67L, brand = Dbrand, category = acc, price = 2000),
              Product(id = 68L, brand = Ebrand, category = acc, price = 2100),
              Product(id = 69L, brand = Fbrand, category = acc, price = 1900),
              Product(id = 70L, brand = Gbrand, category = acc, price = 2000),
              Product(id = 71L, brand = Hbrand, category = acc, price = 2000),
              Product(id = 72L, brand = Ibrand, category = acc, price = 2400)
          )

      }
    }
}












