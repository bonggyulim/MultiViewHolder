package com.example.multiviewholder

fun cardList(): List<CardInfo> {
    return listOf(
        CardInfo(
            CardInfo.BLUE_TYPE,
            name = "Anderson",
            cardNumber = "2423 3581 9503 2412",
            expirationDate = mutableListOf(12, 24),
            price = 3100.3,
        ),CardInfo(
            CardInfo.ORANGE_TYPE,
            name = "Anderson",
            cardNumber = "2423 3581 9503 2412",
            expirationDate = mutableListOf(12, 24),
            price = 3100.3,
        ),CardInfo(
            CardInfo.SKY_TYPE,
            name = "Anderson",
            cardNumber = "2423 3581 9503 2412",
            expirationDate = mutableListOf(12, 24),
            price = 3100.3,
        )
    )
}