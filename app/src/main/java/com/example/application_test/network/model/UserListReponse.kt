package com.example.application_test.network.model

import com.squareup.moshi.Json

data class UserListReponse(
        @Json(name = "User") val User: List<UserResponse>
)

