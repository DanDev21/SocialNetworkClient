package com.dan.socialnetwork.core

import android.app.Application
import android.content.Context
import com.dan.socialnetwork.util.SharedPrefKey
import com.dan.socialnetwork.util.SharedPreferencesManager
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    @Singleton
    fun providesGson(): Gson = Gson()

    @Provides
    @Singleton
    fun providesSharedPreferencesManager(app: Application) =
        SharedPreferencesManager(
            app.getSharedPreferences(
                SharedPrefKey.SHARED_PREFERENCES_MAIN_INSTANCE,
                Context.MODE_PRIVATE
            )
        )

    @Provides
    @Singleton
    fun providesOkHttpClient(manager: SharedPreferencesManager): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor {
                val token = manager.getAuthenticationToken()
                val request = it.request()
                    .newBuilder()
                    .addHeader("Authorization", "Bearer $token")
                    .build()
                it.proceed(request)
            }
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()
}