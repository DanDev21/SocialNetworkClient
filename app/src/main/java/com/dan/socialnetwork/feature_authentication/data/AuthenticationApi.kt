package com.dan.socialnetwork.feature_authentication.data

import com.dan.socialnetwork.core.data.dto.response.SingletonResponse
import com.dan.socialnetwork.util.Routes
import com.dan.socialnetwork.feature_authentication.data.dto.request.SignInRequest
import com.dan.socialnetwork.feature_authentication.data.dto.request.SignupRequest
import com.dan.socialnetwork.util.Url
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthenticationApi {

    companion object {
        const val BASE_URL = Url.BASE
    }

    @POST(Routes.User.SIGN_UP)
    suspend fun signup(
        @Body request: SignupRequest
    ) : Response<Unit>

    @POST(Routes.User.SIGN_IN)
    suspend fun signIn(
        @Body request: SignInRequest
    ) : Response<SingletonResponse<String>>

    @GET(Routes.User.AUTHENTICATE)
    suspend fun authenticate(): Response<Unit>
}