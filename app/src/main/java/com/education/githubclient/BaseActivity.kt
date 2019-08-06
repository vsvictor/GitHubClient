package com.education.githubclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

abstract class BaseActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun isAuthenticate(): Boolean {
        return false
    }
}
