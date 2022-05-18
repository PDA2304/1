package com.example.myapplication1.common

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.myapplication1.presentation.OnBoardingScreen
import com.example.myapplication1.R
import android.content.ClipData.newIntent


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var intent = Intent(this@MainActivity, OnBoardingScreen::class.java)
        intent.flags =
            Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
        Handler().postDelayed(Runnable { startActivity(intent) }, 3000)
    }
}