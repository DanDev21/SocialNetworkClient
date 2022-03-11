package com.dan.socialnetwork.feature_authentication.data.validation

import com.dan.socialnetwork.R
import com.dan.socialnetwork.util.Length
import com.dan.socialnetwork.feature_authentication.data.dto.SignupForm
import com.dan.socialnetwork.feature_authentication.data.validation.SignupException.*
import com.dan.socialnetwork.util.StringUtil

class SignupValidator {

    fun validate(signupForm: SignupForm) {
        when {
            signupForm.password != signupForm.passwordConfirmation -> {
                throw PasswordException(R.string.exception_passwords_do_not_match)
            }
            Length.Min.PASSWORD > signupForm.password.length -> {
                throw PasswordException(R.string.exception_field_too_short)
            }
            Length.Min.USERNAME > signupForm.username.length -> {
                throw UsernameException(R.string.exception_field_too_short)
            }
            StringUtil.isNotValidEmail(signupForm.email) -> {
                throw EmailException(R.string.exception_invalid_email)
            }
        }
    }
}