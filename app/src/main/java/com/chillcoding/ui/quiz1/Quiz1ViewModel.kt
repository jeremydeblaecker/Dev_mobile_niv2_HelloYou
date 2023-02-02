package com.chillcoding.ui.quiz1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chillcoding.Quiz

class Quiz1ViewModel : ViewModel() {
    var quizz = ArrayList<Quiz>()
    var numberofGoodAnswers: Int = 0
    var currentQuizIndex: Int = 0


    fun handleAnswer(answerID: Int) {
        val quiz = quizz[currentQuizIndex]
        if (quiz.isTrue(answerID)) {
            numberofGoodAnswers++
        }

        currentQuizIndex++
    }

    fun isQuizEnded(): Boolean {
        return currentQuizIndex >= quizz.size
    }

    fun getCurrentQuiz(): Quiz {
        return quizz[currentQuizIndex]
    }
}