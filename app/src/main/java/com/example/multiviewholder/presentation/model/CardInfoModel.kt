package com.example.multiviewholder.presentation.model

import android.os.Parcelable
import com.example.multiviewholder.presentation.adapter.MultiViewEnum
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardInfoModel(
    val position: Int,
    val name: String,
    val cardNumber: String,
    val expirationDate: String,
    val price: String,
    val cardViewType: MultiViewEnum
) : Parcelable