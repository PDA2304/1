package com.example.myapplication1.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication1.R
import com.example.myapplication1.adapter.ViewPagerAdapter
import com.example.myapplication1.fragment.Item1Fragment
import kotlinx.android.synthetic.main.activity_on_boarding_screen.*
import kotlinx.android.synthetic.main.fragment_item2.*

class OnBoardingScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_screen)
        ViewPage.adapter = ViewPagerAdapter(this);

    }
}