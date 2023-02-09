package com.kim344.githubuserapisample.di

import com.example.data.GithubRandomRepositoryImpl
import com.example.domain.repository.GithubRandomRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesGithubRandomRepository(repository: GithubRandomRepositoryImpl): GithubRandomRepository {
        return repository
    }

}