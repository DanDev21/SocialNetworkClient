package com.dan.socialnetwork.feature_authentication.data.validation

import com.dan.socialnetwork.R
import com.dan.socialnetwork.util.Length
import com.dan.socialnetwork.feature_authentication.data.dto.request.SignInRequest
import com.dan.socialnetwork.feature_authentication.data.validation.SignInException.*
import com.dan.socialnetwork.util.StringUtil

class SignInValidator {

    fun validate(request: SignInRequest) {
        when {
            request.emailOrUsername.isBlank() -> {
                throw EmailOrUsernameException(R.string.exception_field_empty)
            }
            StringUtil.isNotValidEmail(request.emailOrUsername) -> {
                throw EmailOrUsernameException(R.string.exception_invalid_email)
            }
            request.password.isBlank() -> {
                throw PasswordException(R.string.exception_field_empty)
            }
            Length.Min.PASSWORD > request.password.length -> {
                throw PasswordException(R.string.exception_field_too_short)
            }
        }
    }
}