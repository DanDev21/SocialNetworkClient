package com.dan.socialnetwork.feature_authentication

import com.dan.socialnetwork.feature_authentication.data.AuthenticationApi
import com.dan.socialnetwork.feature_authentication.domain.AuthenticationUseCase
import com.dan.socialnetwork.feature_authentication.domain.SignInUseCase
import com.dan.socialnetwork.feature_authentication.domain.SignupUseCase
import com.dan.socialnetwork.util.SharedPreferencesManager
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
        manager: SharedPreferencesManager
    ) = SignInUseCase(api, manager)

    @Provides
    @Singleton
    fun providesAuthenticationUseCase(api: AuthenticationApi) =
        AuthenticationUseCase(api)
}