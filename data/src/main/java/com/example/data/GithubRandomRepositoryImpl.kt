package com.example.data

import android.util.Log
import com.example.data.source.GithubRandomRemoteSource
import com.example.domain.model.GithubRandom
import com.example.domain.repository.GithubRandomRepository
import javax.inject.Inject

class GithubRandomRepositoryImpl @Inject constructor(
    private val githubRandomRemoteSource: GithubRandomRemoteSource
): GithubRandomRepository {

    override suspend fun getRandom(results: Int): List<GithubRandom> {
        return githubRandomRemoteSource.getRandom(results).results
    }

    override suspend fun getContent(results: Int): List<GithubRandom> {
        return githubRandomRemoteSource.getRandom(results).results
    }

    override suspend fun getReplyList(results: Int): List<GithubRandom> {
        return githubRandomRemoteSource.getRandom(results).results
    }

    override suspend fun getLikeStatus(results: Int): List<GithubRandom> {
        return githubRandomRemoteSource.getRandom(results).results
    }
}