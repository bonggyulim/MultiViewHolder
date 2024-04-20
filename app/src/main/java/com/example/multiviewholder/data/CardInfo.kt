package com.example.multiviewholder.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardInfo(
    val position: Int,
    val name: String,
    val cardNumber: String,
    val expirationDate: String,
    val price: String,
) : Parcelable