package com.dan.socialnetwork.feature_authentication.data.dto.request

data class SignInRequest(
    val emailOrUsername: String,
    val password: String
)
