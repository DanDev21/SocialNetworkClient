package com.dan.socialnetwork.feature_auth.data.validation

import androidx.annotation.StringRes
import com.dan.socialnetwork.util.AppException

sealed class UserInputException : AppException()

sealed class SignupException : UserInputException() {
    data class EmailException(@StringRes override val stringInt: Int) : SignupException()
    data class UsernameException(@StringRes override val stringInt: Int) : SignupException()
    data class PasswordException(@StringRes override val stringInt: Int) : SignupException()
}

sealed class SignInException : UserInputException() {
    data class EmailOrUsernameException(@StringRes override val stringInt: Int) : SignInException()
    data class PasswordException(@StringRes override val stringInt: Int) : SignInException()
}