package com.education.githubclient.http

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HttpClient {
    private val BASE_URL = "https://api.github.com/"
    val client : OkHttpClient
    val api : GitHubAPI
    init {
        client = OkHttpClient.Builder()
            .followRedirects(true)
            .followSslRedirects(true)
            .cache(null)
            .build();
        val gson : Gson = GsonBuilder().create()
        api  = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build().create(GitHubAPI::class.java)
    }
}