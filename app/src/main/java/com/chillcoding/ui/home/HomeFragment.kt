package com.chillcoding.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.chillcoding.R
import com.chillcoding.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        onClicked()
        Log.i(HomeFragment::class.simpleName, getString(R.string.text_oncreate))
    }

    fun onClicked() {
        var button = view?.findViewById<Button>(R.id.mainButton)
        button?.setOnClickListener {
            makeText(activity, getString(R.string.toast_msg), LENGTH_LONG).show()
        }
    }
}