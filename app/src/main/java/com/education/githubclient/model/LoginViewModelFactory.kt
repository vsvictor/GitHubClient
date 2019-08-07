package com.education.githubclient.model

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class LoginViewModelFactory(val application: Application) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LoginModel::class.java)){
            return LoginModel(repository = LoginRepository(LoginDataSource()), app = application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}