package com.example.multiviewholder.data.entity

import com.example.multiviewholder.presentation.adapter.MultiViewEnum

data class CardInfoEntity(
    val position: Int,
    val name: String,
    val cardNumber: String,
    val expirationDate: String,
    val price: String,
    val cardViewType: MultiViewEnum
)