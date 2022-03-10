package com.dan.socialnetwork.feature_auth

import android.content.SharedPreferences
import com.dan.socialnetwork.feature_auth.data.AuthenticationApi
import com.dan.socialnetwork.feature_auth.use_case.SignInUseCase
import com.dan.socialnetwork.feature_auth.use_case.SignupUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthenticationModule {

    @Provides
    @Singleton
    fun providesAuthenticationApi(client: OkHttpClient): AuthenticationApi =
        Retrofit.Builder()
            .baseUrl(AuthenticationApi.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthenticationApi::class.java)

    @Provides
    @Singleton
    fun providesSignupUseCase(api: AuthenticationApi) = SignupUseCase(api)

    @Provides
    @Singleton
    fun providesSignInUseCase(
        api: AuthenticationApi,
        sharedPreferences: SharedPreferences
    ) = SignInUseCase(api, sharedPreferences)
}