package com.example.myapplication1.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication1.R
import com.example.myapplication1.home.Home
import kotlinx.android.synthetic.main.activity_sing_in.*
import kotlinx.android.synthetic.main.activity_sing_up.*
import kotlinx.android.synthetic.main.activity_sing_up.registration

class SingIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_in)

        login.setOnClickListener {
            var intent = Intent(this, Home::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }
}