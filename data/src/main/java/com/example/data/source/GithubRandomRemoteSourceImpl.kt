package com.example.data.source

import com.example.data.model.GithubRandomRes
import com.example.data.service.GithubRandomService
import javax.inject.Inject

class GithubRandomRemoteSourceImpl @Inject constructor(
    private val githubRandomService: GithubRandomService
): GithubRandomRemoteSource {
    override suspend fun getRandom(results: Int): GithubRandomRes {
        return githubRandomService.getRandom(results)
    }
}