package com.example.domain.repository

import com.example.domain.model.GithubRandom

interface GithubRandomRepository {
    suspend fun getRandom(results: Int): List<GithubRandom>

    suspend fun getContent(results: Int): List<GithubRandom>
    suspend fun getReplyList(results: Int): List<GithubRandom>
    suspend fun getLikeStatus(results: Int): List<GithubRandom>
}