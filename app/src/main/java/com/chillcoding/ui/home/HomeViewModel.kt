package com.chillcoding.ui.home

import android.content.Intent
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chillcoding.QuizActivity
import com.chillcoding.QuizTransportActivity
import com.chillcoding.ui.quiz1.Quiz1Fragment
import com.chillcoding.ui.quiz2.Quiz2Fragment
import com.chillcoding.ui.quiz2.Quiz2ViewModel

class HomeViewModel : ViewModel() {
    fun onClickBtnPlay(view: View) {
        val intent = Intent(view.context, Quiz1Fragment::class.java)
        view.context.startActivity(intent)
    }

    fun onClickBtnQuiz(view: View) {
        val intent = Intent(view.context, Quiz2Fragment::class.java)
        view.context.startActivity(intent)
    }
}