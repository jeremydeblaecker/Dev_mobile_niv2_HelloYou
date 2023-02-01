package com.chillcoding.ui.home

import android.content.Intent
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chillcoding.QuizActivity
import com.chillcoding.QuizTransportActivity

class HomeViewModel : ViewModel() {
    fun onClickBtnPlay(view: View) {
        val intent = Intent(view.context, QuizActivity::class.java)
        view.context.startActivity(intent)
    }

    fun onClickBtnQuiz(view: View) {
        val intent = Intent(view.context, QuizTransportActivity::class.java)
        view.context.startActivity(intent)
    }
}