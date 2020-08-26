package com.tsdev.remote.di

import com.tsdev.remote.BuildConfig
import com.tsdev.remote.network.interceptor.CustomInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val REQUEST_TIME_OUT = 2000L

val networkModules = module {
    single {
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
            .baseUrl()
    }

    single<Interceptor>(named("customInterceptor")) { CustomInterceptor() }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<Interceptor>(named("customInterceptor")))
            .addInterceptor(get<Interceptor>(named("logging")))
            .writeTimeout(REQUEST_TIME_OUT, TimeUnit.MILLISECONDS)
            .readTimeout(REQUEST_TIME_OUT, TimeUnit.MILLISECONDS)
            .callTimeout(REQUEST_TIME_OUT, TimeUnit.MILLISECONDS)
            .build()
    }

    single<Interceptor>(named("logging")) {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }
}