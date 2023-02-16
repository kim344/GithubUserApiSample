package com.kim344.githubuserapisample.di

import com.example.domain.repository.GithubRandomRepository
import com.example.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun providesGetGithubRandomUseCase(repository: GithubRandomRepository): GetGithubRandomUseCase {
        return GetGithubRandomUseCase(repository)
    }

    @Provides
    fun providesGetDetailUseCase(getContentUseCase: GetContentUseCase, getLikeUseCase: GetLikeUseCase, getReplyUseCase: GetReplyUseCase): GetDetailUseCase {
        return GetDetailUseCase(getContentUseCase, getLikeUseCase, getReplyUseCase)
    }

    @Provides
    fun providesGetContentUseCase(repository: GithubRandomRepository): GetContentUseCase {
        return GetContentUseCase(repository)
    }

    @Provides
    fun providesGetLikeUseCase(repository: GithubRandomRepository): GetLikeUseCase {
        return GetLikeUseCase(repository)
    }

    @Provides
    fun providesGetReplyUseCase(repository: GithubRandomRepository): GetReplyUseCase {
        return GetReplyUseCase(repository)
    }

}