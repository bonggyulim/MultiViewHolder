package com.example.multiviewholder.data.remote

import com.google.gson.annotations.SerializedName

// 깃허브 api의 데이터를 담을 데이터 클래스
data class GitHubUserListResponse(

    @SerializedName("items") val items: List<GitHubUserResponse>
)

data class GitHubUserResponse(
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("login") val loginName: String
)