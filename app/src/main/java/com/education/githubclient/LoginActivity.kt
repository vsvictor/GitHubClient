package com.education.githubclient

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.education.githubclient.databinding.ActivityLoginBinding
import com.education.githubclient.model.LoginModel
import com.education.githubclient.model.LoginViewModelFactory
import com.education.githubclient.model.MainModel
import com.education.githubclient.model.MainViewModelFactory

class LoginActivity : AppCompatActivity() {
    private lateinit var model : LoginModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binder : ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        model = ViewModelProviders.of(this, LoginViewModelFactory(application)).get(LoginModel::class.java)
        binder.loginModel = model
    }

}
