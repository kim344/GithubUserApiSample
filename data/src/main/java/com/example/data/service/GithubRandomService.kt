package com.example.data.service

import com.example.data.model.GithubRandomRes
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubRandomService {

    @GET("api/")
    suspend fun getRandom(
        @Query("results") results: Int
    ): GithubRandomRes

}