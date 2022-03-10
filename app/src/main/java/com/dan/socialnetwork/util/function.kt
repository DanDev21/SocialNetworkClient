package com.dan.socialnetwork.util

import com.dan.socialnetwork.R
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

inline fun confirmSafely(block: () -> Response<Unit>) = handleSafely(block)

inline fun <reified T> handleSafely(block: () -> Response<T>): Result<T> =
    try {
        val response = block()
        val body = response.body()
        if (response.isSuccessful && body is T) {
            Result.Success(body)
        } else {
            Result.ServerError(response.message())        }
    } catch (e: IOException) {
        Result.ResourceError(R.string.exception_cannot_reach_the_server)
    } catch (e: HttpException) {
        Result.ResourceError(R.string.exception_http)
    } catch (e: Exception) {
        Result.ResourceError(R.string.unknown)
    }