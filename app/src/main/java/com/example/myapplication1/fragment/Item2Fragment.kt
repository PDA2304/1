package com.example.myapplication1.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Log.INFO
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication1.R
import com.example.myapplication1.presentation.SingIn
import kotlinx.android.synthetic.main.fragment_item2.*
import java.util.logging.Level.INFO

class Item2Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_item2, container, false)
        view.findViewById<Button>(R.id.sing_in).setOnClickListener {
            var intent = Intent(this.context,SingIn::class.java);
            startActivity(intent);
        }
        return view
    }

    override fun onAttach(context: Context) {

        super.onAttach(context)
    }

}