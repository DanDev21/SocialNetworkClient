package com.dan.socialnetwork.feature_auth.data.dto.request

data class SignupRequest(
    val email: String,
    val username: String,
    val password: String
)