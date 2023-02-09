package com.example.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.model.GithubRandom
import com.example.domain.usecase.GetGithubRandomUseCase
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel  @Inject constructor(
    private val getGithubRandomUseCase: GetGithubRandomUseCase
): BaseViewModel() {

    private val _githubRandomUsers = MutableLiveData<List<GithubRandom>>()
    val githubRandomUsers: LiveData<List<GithubRandom>> = _githubRandomUsers

    fun getGithubRandomUsers(results: Int) {
        getGithubRandomUseCase(results, viewModelScope) {
            _githubRandomUsers.value = it
        }
    }

}