package com.example.multiviewholder.presentation.mapper

import com.example.multiviewholder.data.entity.CardInfoEntity
import com.example.multiviewholder.presentation.model.CardInfoModel

// 타입 변경하는 코드
fun List<CardInfoEntity>.asCardInfoModel() : List<CardInfoModel> {
    return map {
        CardInfoModel(
            it.position,
            it.name,
            it.cardNumber,
            it.expirationDate,
            it.price,
            it.cardViewType)
    }
}