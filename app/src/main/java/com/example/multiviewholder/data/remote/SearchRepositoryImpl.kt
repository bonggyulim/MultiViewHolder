package com.example.multiviewholder.data.remote

import com.example.multiviewholder.data.database.DataSource
import com.example.multiviewholder.presentation.main.mapper.asCardInfoModel
import com.example.multiviewholder.presentation.search.mapper.toEntity
import com.example.multiviewholder.presentation.search.repository.SearchRepository


// Repository 인터페이스를 상속받음
// 모아놓으는 Repository패턴을 리턴함
class SearchRepositoryImpl(
    private val dataSource: DataSource,
    private val remoteDataSource: SearchRemoteDataSource
    ) : SearchRepository {
        override fun getCardList() = dataSource.getCardList().asCardInfoModel()

        override suspend fun getGitHubUserList(userName: String) =
            remoteDataSource.getGitHubUser(userName).toEntity()
}