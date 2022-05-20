package com.example.myapplication1.home.ui.home

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.R
import com.example.myapplication1.adapter.adapterRecyclerView
import com.example.myapplication1.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        var recyc = root.findViewById<RecyclerView>(R.id.recyc)
        recyc.adapter = adapterRecyclerView(root.context) {
            root.findViewById<CardView>(R.id.card).visibility = View.VISIBLE
            recyc.visibility = View.GONE
        }

        root.findViewById<ImageButton>(R.id.cancel_card).setOnClickListener {
            root.findViewById<CardView>(R.id.card).visibility = View.GONE
            recyc.visibility = View.VISIBLE
        }
        recyc.layoutManager = GridLayoutManager(activity, 2)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}