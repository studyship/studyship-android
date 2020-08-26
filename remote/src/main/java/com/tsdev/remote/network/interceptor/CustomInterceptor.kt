package com.tsdev.remote.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

internal class CustomInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        return chain.proceed(
            chain.request().newBuilder()
//                .addHeader()
//                .addHeader()
                .build()
        )
    }

}
