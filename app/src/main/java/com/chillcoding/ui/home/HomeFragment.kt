package com.chillcoding.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.chillcoding.R
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //View is definied to show the layout from fragrment home
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        onClicked(view)
        Log.i(HomeFragment::class.simpleName, getString(R.string.text_oncreate))
    }
    //When the button 'mainButton' is clicked create Toast to say Hi
    //When the button 'jouer' is clicked start Quiz 1
    //When the button 'button3' is clicked start Quiz 2
    fun onClicked(view: View) {
        var mainButton = view.findViewById<Button>(R.id.mainButton)
        mainButton.setOnClickListener {
            Toast.makeText(view.context, getString(R.string.toast_msg), Toast.LENGTH_LONG).show()
        }
        var jouer = view.findViewById<Button>(R.id.jouer)
        jouer.setOnClickListener {
            homeViewModel.onClickBtnPlay(view)
        }

        var button3 = view.findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            homeViewModel.onClickBtnQuiz(view)
        }
    }
}