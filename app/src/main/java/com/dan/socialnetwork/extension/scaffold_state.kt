package com.dan.socialnetwork.extension

import android.content.Context
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import com.dan.socialnetwork.core.data.dto.Result

suspend fun <T> ScaffoldState.showSnackBar(error: Result.Error<T>, context: Context) {
    val message =
        when (error) {
            is Result.ResourceError -> {
                context.getString(error.stringInt)
            }
            is Result.ServerError -> {
                error.message
            }
        }
    snackbarHostState.showSnackbar(message, duration = SnackbarDuration.Long)
}