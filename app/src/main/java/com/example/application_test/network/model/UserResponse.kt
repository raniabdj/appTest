package com.example.application_test.network.model

import com.squareup.moshi.Json

data class UserResponse(
        val avatar: String,
        val email: String,
        val first_name: String,
        val id: Int,
        val last_name: String,
       // @Json(name = "hero_image") val imgSrcUrl: String
)