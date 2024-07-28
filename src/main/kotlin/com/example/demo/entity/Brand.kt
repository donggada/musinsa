package com.example.demo.entity

data class Brand(
     val id : Long,
     val name: String = ""
) {

     fun isSameName(brandName: String): Boolean {
          return name == brandName
     }

     companion object {
          fun of (id: Int, name: String): Brand {
               return Brand(id = id + 1L, name = name)
          }

          fun fixture(id : Long = 0L, name: String = "") : Brand {
               return Brand(id = id, name = name)
          }

          fun metaDateInit(): MutableList<Brand> {
               return mutableListOf(
                    Brand(id = 1L, name = "A"),
                    Brand(id = 2L, name = "B"),
                    Brand(id = 3L, name = "C"),
                    Brand(id = 4L, name = "D"),
                    Brand(id = 5L, name = "E"),
                    Brand(id = 6L, name = "F"),
                    Brand(id = 7L, name = "G"),
                    Brand(id = 8L, name = "H"),
                    Brand(id = 9L, name = "I"),
                    )
          }
     }
}
