package com.example.application_test.feature.liste.repo

import com.example.application_test.network.Service
import com.example.application_test.network.UIState
import com.example.application_test.network.model.UserResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UserRepository @Inject constructor(
    private val testService: Service
) {
    private val _userList: MutableStateFlow <UIState> = MutableStateFlow (UIState.LOADING())
    val userListResponse: StateFlow<UIState>
    get()= _userList
    suspend fun getUserInfo(){
    val response = testService.getUserResponse()
    val users: MutableList<UserResponse> =mutableListOf()
        if(response.isSuccessful){
            response.body()?.let {
                it.User.forEachIndexed { index, userResponse ->
                   users.add(userResponse)
                }
            }
            _userList.value=UIState.SUCCESS(users)
        }else{
            _userList.value=UIState.ERROR(Exception(response.errorBody()?.string()))
        }
    }
}