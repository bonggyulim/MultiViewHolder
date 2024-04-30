package com.example.multiviewholder.data.database

import com.example.multiviewholder.data.entity.CardInfoEntity

object DataSource {
    fun getCardList(): List<CardInfoEntity> {
        return cardList()
    }
}