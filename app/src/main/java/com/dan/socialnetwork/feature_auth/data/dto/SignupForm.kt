package com.dan.socialnetwork.feature_auth.data.dto

data class SignupForm(
    val email: String,
    val username: String,
    val password: String,
    val passwordConfirmation: String,
)