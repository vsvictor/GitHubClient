package com.education.githubclient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class StartActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(isAuthenticate()){
            startActivity(Intent(this, MainActivity::class.java))
        }else{
            startActivity(Intent(this, LoginActivity::class.java))
        }
        finish()
    }
}
