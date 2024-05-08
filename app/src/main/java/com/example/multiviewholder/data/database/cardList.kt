package com.example.multiviewholder.data.database

import com.example.multiviewholder.data.entity.CardInfoEntity
import com.example.multiviewholder.presentation.main.adapter.MultiViewEnum

fun cardList(): List<CardInfoEntity> {
    return listOf(
        CardInfoEntity(
            position = 0,
            name = "Anderson",
            cardNumber = "2423 3581 9503 2412",
            expirationDate = "12/24",
            price = "3100.3",
            MultiViewEnum.BLUE
        ), CardInfoEntity(
            position = 1,
            name = "second",
            cardNumber = "2222 2222 2222 2222",
            expirationDate = "02/22",
            price = "2222.2",
            MultiViewEnum.ORANGE
        ), CardInfoEntity(
            position = 2,
            name = "third",
            cardNumber = "3333 3333 3333 3333",
            expirationDate = "03/33",
            price = "3333.3",
            MultiViewEnum.LIGHTBLUE
        ),
        CardInfoEntity(
            position = 0,
            name = "Anderson",
            cardNumber = "2423 3581 9503 2412",
            expirationDate = "12/24",
            price = "3100.3",
            MultiViewEnum.BLUE
        ), CardInfoEntity(
            position = 1,
            name = "second",
            cardNumber = "2222 2222 2222 2222",
            expirationDate = "02/22",
            price = "2222.2",
            MultiViewEnum.ORANGE
        ), CardInfoEntity(
            position = 2,
            name = "third",
            cardNumber = "3333 3333 3333 3333",
            expirationDate = "03/33",
            price = "3333.3",
            MultiViewEnum.LIGHTBLUE
        )
    )
}