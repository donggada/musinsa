package com.example.demo.utill

import java.text.DecimalFormat

class FormatPriceWithDecimalFormat {

    companion object  {
        fun format(price: Int): String {
            val decimalFormat = DecimalFormat("#,###")
            return decimalFormat.format(price)
        }
    }

}