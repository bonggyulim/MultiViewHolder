package com.example.multiviewholder.data

fun cardList(): List<CardInfo> {
    return listOf(
        CardInfo(
            position = 0,
            name = "Anderson",
            cardNumber = "2423 3581 9503 2412",
            expirationDate = "12/24",
            price = "3100.3",
        ), CardInfo(
            position = 1,
            name = "second",
            cardNumber = "2222 2222 2222 2222",
            expirationDate = "02/22",
            price = "2222.2",
        ), CardInfo(
            position = 2,
            name = "third",
            cardNumber = "3333 3333 3333 3333",
            expirationDate = "03/33",
            price = "3333.3",
        )
    )
}