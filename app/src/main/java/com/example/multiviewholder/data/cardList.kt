package com.example.multiviewholder.data

fun cardList(): List<CardInfo> {
    return listOf(
        CardInfo(
            position = 0,
            MultiViewEnum.BLUE,
            name = "Anderson",
            cardNumber = "2423 3581 9503 2412",
            expirationDate = mutableListOf(12, 24),
            price = 3100.3,
        ), CardInfo(
            position = 1,
            MultiViewEnum.ORANGE,
            name = "second",
            cardNumber = "2222 2222 2222 2222",
            expirationDate = mutableListOf(22, 22),
            price = 2222.2,
        ), CardInfo(
            position = 2,
            MultiViewEnum.LIGHTBLUE,
            name = "third",
            cardNumber = "3333 3333 3333 3333",
            expirationDate = mutableListOf(33, 33),
            price = 3333.3,
        )
    )
}