package com.dan.socialnetwork.feature_auth.use_case

import com.dan.socialnetwork.feature_auth.data.AuthenticationApi
import com.dan.socialnetwork.feature_auth.data.dto.SignupForm
import com.dan.socialnetwork.feature_auth.data.dto.request.SignupRequest
import com.dan.socialnetwork.feature_auth.data.validation.SignupValidator
import com.dan.socialnetwork.util.Result
import com.dan.socialnetwork.util.confirmSafely

class SignupUseCase(private val api: AuthenticationApi) {

    private val signupValidator = SignupValidator()

    suspend operator fun invoke(signupForm: SignupForm): Result<Unit> {
        signupValidator.validate(signupForm)

        val request = SignupRequest(
            email = signupForm.email,
            username = signupForm.username,
            password = signupForm.password,
        )

        return confirmSafely {
            api.signup(request)
        }
    }
}