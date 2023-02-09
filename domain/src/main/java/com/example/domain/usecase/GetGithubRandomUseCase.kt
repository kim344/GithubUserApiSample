package com.example.domain.usecase

import com.example.domain.model.GithubRandom
import com.example.domain.repository.GithubRandomRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class GetGithubRandomUseCase(private val githubRandomRepository: GithubRandomRepository) {

    operator fun invoke(
        results: Int,
        scope: CoroutineScope,
        onResult: (List<GithubRandom>) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                githubRandomRepository.getRandom(results)
            }
            onResult(deferred.await())
        }
    }


}