package com.chillcoding.ui.home

import android.content.Intent
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.chillcoding.R
import com.chillcoding.ui.quiz1.Quiz1Fragment
import com.chillcoding.ui.quiz2.Quiz2Fragment

class HomeViewModel : ViewModel() {
    //When the button 'jouer' is clicked start Quiz 1
    fun onClickBtnPlay(view: View) {
        val fragment = Quiz1Fragment()
        val fragmentManager = (view.context as FragmentActivity).supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
    //When the button 'button3' is clicked start Quiz 2
    fun onClickBtnQuiz(view: View) {
        val fragment = Quiz2Fragment()
        val fragmentManager = (view.context as FragmentActivity).supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}