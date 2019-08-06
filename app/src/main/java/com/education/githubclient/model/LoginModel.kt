package com.education.githubclient.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class LoginModel(app : Application) : AndroidViewModel(app){
    val user : User = User(app.applicationContext)
}