package com.kim344.domain.repository

import com.kim344.domain.model.User
import io.reactivex.Single

interface UserRepository {

    fun getUserData(
        results: String
    ): Single<User>

}