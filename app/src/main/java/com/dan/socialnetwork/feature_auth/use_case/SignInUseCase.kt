package com.dan.socialnetwork.feature_auth.use_case

import android.content.SharedPreferences
import com.dan.socialnetwork.core.data.dto.response.SingletonResponse
import com.dan.socialnetwork.util.SharedPrefKey
import com.dan.socialnetwork.feature_auth.data.AuthenticationApi
import com.dan.socialnetwork.feature_auth.data.dto.request.SignInRequest
import com.dan.socialnetwork.feature_auth.data.validation.SignInValidator
import com.dan.socialnetwork.util.Result
import com.dan.socialnetwork.util.handleSafely

class SignInUseCase(
    private val api: AuthenticationApi,
    private val sharedPreferences: SharedPreferences,
) {

    private val signInValidator = SignInValidator()

    suspend operator fun invoke(
        emailOrUsername: String,
        password: String
    ) : Result<SingletonResponse<String>> {
        val request = SignInRequest(
            emailOrUsername = emailOrUsername,
            password = password
        )

        signInValidator.validate(request)

        return handleSafely { api.signIn(request) }
            .also { saveTokenIfSucceeded(it) }
    }

    private fun saveTokenIfSucceeded(result: Result<SingletonResponse<String>>) {
        if (result is Result.Success) {
            sharedPreferences.edit()
                .putString(SharedPrefKey.JWT, result.data.obj)
                .apply()
        }
    }
}