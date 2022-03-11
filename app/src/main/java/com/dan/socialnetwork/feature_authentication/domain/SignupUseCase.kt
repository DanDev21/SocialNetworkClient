package com.dan.socialnetwork.feature_authentication.domain

import com.dan.socialnetwork.feature_authentication.data.AuthenticationApi
import com.dan.socialnetwork.feature_authentication.data.dto.SignupForm
import com.dan.socialnetwork.feature_authentication.data.dto.request.SignupRequest
import com.dan.socialnetwork.feature_authentication.data.validation.SignupValidator
import com.dan.socialnetwork.core.data.dto.Result
import com.dan.socialnetwork.util.handle

class SignupUseCase(private val api: AuthenticationApi) {

    private val signupValidator = SignupValidator()

    suspend operator fun invoke(signupForm: SignupForm): Result<Unit> {
        signupValidator.validate(signupForm)
        val request = SignupRequest(
            email = signupForm.email,
            username = signupForm.username,
            password = signupForm.password,
        )
        return handle { api.signup(request) }
    }
}