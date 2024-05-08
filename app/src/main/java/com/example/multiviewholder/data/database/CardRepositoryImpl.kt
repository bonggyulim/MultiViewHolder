package com.example.multiviewholder.data.database

import com.example.multiviewholder.presentation.main.mapper.asCardInfoModel
import com.example.multiviewholder.presentation.search.model.GitHubUserListEntity
import com.example.multiviewholder.presentation.search.repository.SearchRepository

class CardRepositoryImpl(private val dataSource: DataSource): SearchRepository {
    override fun getCardList() = dataSource.getCardList().asCardInfoModel()
    override suspend fun getGitHubUserList(userName: String): GitHubUserListEntity {
        TODO("Not yet implemented")
    }
}