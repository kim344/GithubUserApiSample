package com.kim344.githubuserapisample.di

import com.example.data.source.GithubRandomRemoteSource
import com.example.data.source.GithubRandomRemoteSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun providesGithubRandomRemoteSource(source: GithubRandomRemoteSourceImpl): GithubRandomRemoteSource {
        return source
    }

}