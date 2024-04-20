package com.example.multiviewholder.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardInfo(
    val position: Int,
    val type: MultiViewEnum,
    val name: String,
    val cardNumber: String,
    val expirationDate: List<Int>,
    val price: Double,
) : Parcelable