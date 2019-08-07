package com.education.githubclient.model

import android.app.Application
import android.content.Intent
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import com.education.githubclient.MainActivity

class LoginModel(val app : Application, private val repository: LoginRepository) : AndroidViewModel(app){
    val user : User = User()
    val observer = repository.userChannel.observeForever(Observer {
        user.displayName = it.displayName
        user.avatar = it.avatar
        user.url = it.url
        user.followers = it.followers
        user.following = it.following
        val intent = Intent(app.applicationContext, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.putExtra("user", user)
        app.applicationContext.startActivity(intent)

    })
    fun login(view : View){
        user.email = "dvictor74@gmail.com"
        user.password = "Vestern74"
        repository.login(user.email?:"", user.password?:"")
    }
}