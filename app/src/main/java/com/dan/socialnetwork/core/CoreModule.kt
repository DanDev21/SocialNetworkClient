package com.dan.socialnetwork.core

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.dan.socialnetwork.util.SharedPrefKey
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
    fun providesSharedPreferences(app: Application): SharedPreferences =
        app.getSharedPreferences(
            SharedPrefKey.SHARED_PREFERENCES_MAIN_INSTANCE,
            Context.MODE_PRIVATE
        )

    @Provides
    @Singleton
    fun providesOkHttpClient(sharedPreferences: SharedPreferences): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor {
                val token = sharedPreferences.getString(SharedPrefKey.JWT, "")
                val request =
                    it.request()
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