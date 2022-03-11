package com.dan.socialnetwork.feature_authentication.domain

import com.dan.socialnetwork.feature_authentication.data.AuthenticationApi
import com.dan.socialnetwork.util.handle

class AuthenticationUseCase(private val api: AuthenticationApi) {

    suspend operator fun invoke() = handle { api.authenticate() }
}