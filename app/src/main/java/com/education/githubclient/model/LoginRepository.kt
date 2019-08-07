package com.education.githubclient.model

import androidx.lifecycle.MutableLiveData

class LoginRepository(val source : LoginDataSource) : LoginDataSource.OnLogin {
    val userChannel = MutableLiveData<GitHubUser>()
    fun login(userName : String, password : String){
        source.setOnLoginListener(this)
        source.login(userName, password)
    }

    override fun onLogin(user: GitHubUser?) {
        userChannel.value= user
    }

    override fun onFail() {
    }
}