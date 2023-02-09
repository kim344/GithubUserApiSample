package com.example.data.source

import com.example.data.model.GithubRandomRes

interface GithubRandomRemoteSource {
    suspend fun getRandom(
        results: Int
    ): GithubRandomRes
}