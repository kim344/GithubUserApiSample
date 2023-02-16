package com.example.domain.usecase

import com.example.domain.model.GithubRandom
import kotlinx.coroutines.CoroutineScope

class GetDetailUseCase(
    private val getContentUseCase: GetContentUseCase,
    private val getLikeUseCase: GetLikeUseCase,
    private val getReplyUseCase: GetReplyUseCase
) {

    fun contentExecute(
        results: Int,
        scope: CoroutineScope,
        onResult: (List<GithubRandom>) -> Unit = {}
    ) {
        getContentUseCase.invoke(results, scope, onResult)
    }

    fun likeExecute(
        results: Int,
        scope: CoroutineScope,
        onResult: (List<GithubRandom>) -> Unit = {}
    ) {
        getLikeUseCase.invoke(results, scope, onResult)
    }

    fun replyExecute(
        results: Int,
        scope: CoroutineScope,
        onResult: (List<GithubRandom>) -> Unit = {}
    ) {
        getReplyUseCase.invoke(results, scope, onResult)
    }

}