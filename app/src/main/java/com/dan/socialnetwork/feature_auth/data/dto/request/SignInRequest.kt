package com.dan.socialnetwork.feature_auth.data.dto.request

data class SignInRequest(
    val emailOrUsername: String,
    val password: String
)
