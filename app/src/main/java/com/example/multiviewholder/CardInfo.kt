package com.example.multiviewholder

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardInfo(
    val type: Int,
    val name: String,
    val cardNumber: String,
    val expirationDate: List<Int>,
    val price: Double,
) : Parcelable {
    companion object {
        const val BLUE_TYPE = 0
        const val ORANGE_TYPE = 1
        const val SKY_TYPE = 2
    }

}
