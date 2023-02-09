package com.example.domain.repository

import com.example.domain.model.GithubRandom

interface GithubRandomRepository {
    suspend fun getRandom(results: Int): List<GithubRandom>
}