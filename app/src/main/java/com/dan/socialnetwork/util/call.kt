package com.dan.socialnetwork.util

import com.dan.socialnetwork.R
import com.dan.socialnetwork.core.data.dto.Result
import com.dan.socialnetwork.core.data.dto.response.SingletonResponse
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

inline fun handle(block: () -> Response<Unit>) =
    safely {
        val response = block()
        if (response.isSuccessful) {
            Result.Success(Unit)
        } else {
            Result.ServerError(response.message())
        }
    }

inline fun <reified T : Any> handleResponseOf(block: () -> Response<SingletonResponse<T>>) =
    safely {
        val response = block()
        val body = response.body()
        if (response.isSuccessful && body is SingletonResponse<T>) {
            Result.Success(body.obj)
        } else {
            Result.ServerError(response.message())
        }
    }

inline fun <reified T : Any> safely(block: () -> Result<T>): Result<T> =
    try {
        block()
    } catch (e: IOException) {
        Result.ResourceError(R.string.exception_cannot_reach_the_server)
    } catch (e: HttpException) {
        Result.ResourceError(R.string.exception_http)
    } catch (e: Exception) {
        Result.ResourceError(R.string.unknown)
    }