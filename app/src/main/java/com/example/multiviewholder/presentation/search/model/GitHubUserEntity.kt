package com.example.multiviewholder.presentation.search.model

// Entity를 사용해서 직렬화된 데이터와 구분함
data class GitHubUserListEntity(val items: List<GitHubUserEntity>)
data class GitHubUserEntity(val avatarUrl: String, val loginName: String)
