package com.example.androidexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()
        }, 2500)
    }
}