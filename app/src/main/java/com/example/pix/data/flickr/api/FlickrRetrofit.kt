package com.example.pix.data.flickr.api

import com.example.pix.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FlickrRetrofit {

    private const val API_KEY_NAME = "api_key"

    private val addApiKeyHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val oldReq = chain.request()
            val newUrl = oldReq.url.newBuilder()
                .addQueryParameter(API_KEY_NAME, BuildConfig.FLICKR_API_KEY)
                .build()
            val newRequest = oldReq.newBuilder().url(newUrl).build()
            chain.proceed(newRequest)
        }.addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        ).build()

    val api = lazy {
        Retrofit.Builder()
            .baseUrl("https://www.flickr.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(addApiKeyHttpClient)
            .build()
            .create(FlickrApi::class.java)
    }
}