package com.example.mygiphyapp.data.retrofit

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.Request
import okhttp3.ResponseBody

class MyLoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()

        println("Request URL: ${request.url}")

        val response = chain.proceed(request)

        println("Response Code: ${response.code}")

        val responseBody = response.body
        val bodyString = responseBody?.string()
        println("Response Body: $bodyString")

        // Rebuild the response so that it can be consumed by the application
        return response.newBuilder()
            .body(ResponseBody.create(responseBody?.contentType(), bodyString.orEmpty()))
            .build()
    }
}