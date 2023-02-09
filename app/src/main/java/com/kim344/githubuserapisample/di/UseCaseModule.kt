package com.kim344.githubuserapisample.di

import com.example.domain.repository.GithubRandomRepository
import com.example.domain.usecase.GetGithubRandomUseCase
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

}