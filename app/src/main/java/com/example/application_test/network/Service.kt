package com.example.application_test.network

import com.example.application_test.network.model.User
import com.example.application_test.network.model.UserListReponse
import retrofit2.Response
import retrofit2.http.GET

const val BASE_URL =
    "https://reqres.in/api/"

interface Service {

    @GET("users")
    suspend fun getUserResponse(): Response<UserListReponse>
}
