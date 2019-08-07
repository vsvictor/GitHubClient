package com.education.githubclient.model

import android.os.HandlerThread
import android.util.Log
import com.education.githubclient.http.HttpClient
import com.education.githubclient.utils.StringUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import java.util.logging.Handler

class LoginDataSource {
    private val TAG = LoginDataSource::class.java.simpleName
    private val thread : HandlerThread
    private val handler : android.os.Handler
    private var onLogin : OnLogin? = null
    init {
        thread = HandlerThread("http")
        thread.start()
        handler = android.os.Handler(thread.looper)
    }
    fun login(userName : String, password : String){
        handler.post {
            val client = HttpClient()
            val data = StringUtils.encodeString(userName+":"+password)
            val header = "Basic "+ data
            client.api.getBasicUser(header).enqueue(object : Callback<GitHubUser>{
                override fun onResponse(call: Call<GitHubUser>, response: Response<GitHubUser>) {
                    onLogin?.onLogin(response.body())
                }
                override fun onFailure(call: Call<GitHubUser>, t: Throwable) {
                    //Log.i(TAG, t.message)
                    t.printStackTrace()
                }

            })
        }
    }

    fun setOnLoginListener(listener : OnLogin){
        this.onLogin = listener
    }

    interface OnLogin{
        fun onLogin(user : GitHubUser?)
        fun onFail()
    }
}