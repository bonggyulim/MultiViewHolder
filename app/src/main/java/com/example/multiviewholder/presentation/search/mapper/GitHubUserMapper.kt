package com.example.multiviewholder.presentation.search.mapper

import com.example.multiviewholder.data.remote.GitHubUserListResponse
import com.example.multiviewholder.data.remote.GitHubUserResponse
import com.example.multiviewholder.presentation.search.model.GitHubUserEntity
import com.example.multiviewholder.presentation.search.model.GitHubUserListEntity

// Mapper를 통해 직렬화된 데이터를 Entity로 바꿈
fun GitHubUserListResponse.toEntity() = GitHubUserListEntity(
    items = items.asGitHubUserEntity()
)

fun List<GitHubUserResponse>.asGitHubUserEntity(): List<GitHubUserEntity> {
    return map {
        GitHubUserEntity(
            it.avatarUrl,
            it.loginName
        )
    }
}