package com.dan.socialnetwork.feature_authentication.domain

import com.dan.socialnetwork.feature_authentication.data.AuthenticationApi
import com.dan.socialnetwork.feature_authentication.data.dto.request.SignInRequest
import com.dan.socialnetwork.feature_authentication.data.validation.SignInValidator
import com.dan.socialnetwork.core.data.dto.Result
import com.dan.socialnetwork.util.SharedPreferencesManager
import com.dan.socialnetwork.util.handleResponseOf

class SignInUseCase(
    private val api: AuthenticationApi,
    private val manager: SharedPreferencesManager,
) {

    private val signInValidator = SignInValidator()

    suspend operator fun invoke(emailOrUsername: String, password: String) : Result<String> {
        val request = SignInRequest(
            emailOrUsername = emailOrUsername,
            password = password
        )

        signInValidator.validate(request)

        return handleResponseOf { api.signIn(request) }
            .also { saveTokenIfSucceeded(it) }
    }

    private fun saveTokenIfSucceeded(result: Result<String>) {
        if (result is Result.Success) {
            manager.safeAuthenticationToken(result.data)
        }
    }
}