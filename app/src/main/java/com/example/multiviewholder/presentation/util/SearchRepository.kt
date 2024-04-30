package com.example.multiviewholder.presentation.util

import com.example.multiviewholder.presentation.model.CardInfoModel

interface SearchRepository {
    fun getCardList() : List<CardInfoModel>
}