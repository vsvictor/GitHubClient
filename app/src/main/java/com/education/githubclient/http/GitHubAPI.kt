package com.education.githubclient.http

import com.education.githubclient.model.GitHubUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface GitHubAPI {
    @Headers("Content-Type: application/json")
    @GET("user")
    fun getBasicUser(@Header("Authorization") auth:String): Call<GitHubUser>
}