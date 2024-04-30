package com.example.multiviewholder.data.database

import com.example.multiviewholder.presentation.util.SearchRepository
import com.example.multiviewholder.presentation.mapper.asCardInfoModel

class CardRepositoryImpl(private val dataSource: DataSource): SearchRepository {
    override fun getCardList() = dataSource.getCardList().asCardInfoModel()
}