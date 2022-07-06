package com.kim344.domain.di

import com.kim344.domain.repository.UserRepository
import com.kim344.domain.usecase.GetUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetUserUseCase(userRepository: UserRepository): GetUserUseCase {
        return GetUserUseCase(userRepository)
    }

}