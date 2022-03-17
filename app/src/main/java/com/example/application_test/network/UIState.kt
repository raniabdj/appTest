package com.example.application_test.network

import com.example.application_test.network.model.User
import com.example.application_test.network.model.UserListReponse
import com.example.application_test.network.model.UserResponse


sealed class UIState {
    class LOADING(val isLoading: Boolean = true) : UIState()
    class SUCCESS(val response: List<UserResponse>): UIState()
    class ERROR(val error: Throwable): UIState()
}
