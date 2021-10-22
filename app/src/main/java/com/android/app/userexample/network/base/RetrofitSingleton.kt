package com.android.app.userexample.network.base

import com.android.app.userexample.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Vladyslav Bondar on 22.10.2021.
 * skype: diginital
 */
object RetrofitSingleton {

    private fun buildLoggers(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()

        loggingInterceptor.level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE

        return loggingInterceptor
    }

    private fun buildOKHttp()  = OkHttpClient.Builder()
        .addInterceptor(buildLoggers())
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()

    private fun buildRetrofit() = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(buildOKHttp())
        .build()

    fun buildApiEngine() = buildRetrofit().create(UserApiEngine::class.java)

}