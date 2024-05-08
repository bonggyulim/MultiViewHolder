package com.example.multiviewholder.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

// api에 요청을 보내는 인터페이스
interface SearchRemoteDataSource {
    @GET("/search/users")
    suspend fun getGitHubUser(
        @Query("q") name: String,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 100
        // 보낸 요청은 GitHubUserListResponse로 서비스 수신
    ) : GitHubUserListResponse

}