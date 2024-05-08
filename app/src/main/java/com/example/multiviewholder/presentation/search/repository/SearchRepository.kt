package com.example.multiviewholder.presentation.search.repository

import com.example.multiviewholder.presentation.main.model.CardInfoModel
import com.example.multiviewholder.presentation.search.model.GitHubUserListEntity

// Repository 패턴을 모아놓는 인터페이스
// Repository 패턴을 사용하여 보안, 확장, 코드분리 등의 이점
interface SearchRepository {
    fun getCardList() : List<CardInfoModel>
    suspend fun getGitHubUserList(userName : String) : GitHubUserListEntity
}