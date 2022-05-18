package com.example.myapplication1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication1.R
import com.example.myapplication1.fragment.Item1Fragment
import com.example.myapplication1.fragment.Item2Fragment

class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    private val page = intArrayOf(
        R.layout.fragment_item1,
        R.layout.fragment_item2
    )

    override fun getItemCount(): Int  = page.size

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                return Item1Fragment()
            }
            1 -> {
                return Item2Fragment()
            }
        }
        return Item1Fragment()
    }
}
