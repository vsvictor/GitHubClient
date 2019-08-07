package com.education.githubclient.model

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class MainViewModelFactory(val application: Application, val user : User) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainModel::class.java)){
            return MainModel(app = application, user = user) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}