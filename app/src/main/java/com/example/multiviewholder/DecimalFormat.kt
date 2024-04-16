package com.example.multiviewholder

import java.text.DecimalFormat

object DecimalFormat {
    fun decimalFormat(num: Double): String {
        val dec = DecimalFormat("#,###.00")
        return dec.format(num)
    }
}