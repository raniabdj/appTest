package com.example.application_test.feature.liste.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.application_test.feature.liste.repo.UserRepository
import com.example.application_test.network.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.collect

@HiltViewModel
class UserViewModel @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val userRepository: UserRepository
): ViewModel() {
    private val _users: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING())
    val users: LiveData<UIState>
        get() = _users
    fun getUsers() {
        viewModelScope.launch {
           userRepository.getUserInfo()
               userRepository.userListResponse.collect {uiState ->
                when(uiState) {
                    is UIState.LOADING -> { _users.postValue(uiState) }
                    is UIState.SUCCESS -> { _users.postValue(uiState) }
                    is UIState.ERROR -> { _users.postValue(uiState) }
                }
            }
        }
    }
}