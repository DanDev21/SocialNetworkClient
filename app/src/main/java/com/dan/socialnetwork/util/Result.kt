package com.dan.socialnetwork.util

import androidx.annotation.StringRes

sealed class Result <T> {
    data class Success <T> (val data: T) : Result<T>()

    sealed class Error <T> : Result<T>()
    data class ResourceError <T>(@StringRes val stringInt: Int) : Error<T>()
    data class ServerError <T> (val message: String) : Error<T>()
}