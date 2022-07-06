package com.kim344.domain.usecase

import com.kim344.domain.model.User
import com.kim344.domain.repository.UserRepository
import io.reactivex.Single
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val userRepository: UserRepository){

    fun execute(
        results: String
    ): Single<User> = userRepository.getUserData(results)

}