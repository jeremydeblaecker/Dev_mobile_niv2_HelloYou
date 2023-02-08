package com.chillcoding.ui.quiz1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chillcoding.Quiz

class Quiz1ViewModel : ViewModel() {
    var quizz = ArrayList<Quiz>()
    var numberofGoodAnswers: Int = 0
    var currentQuizIndex: Int = 0

    //Calculate the number of good answers given
    fun handleAnswer(answerID: Int) {
        val quiz = quizz[currentQuizIndex]
        if (quiz.isTrue(answerID)) {
            numberofGoodAnswers++
        }

        currentQuizIndex++
    }

    //Check if the current question is part of the index size if not end quiz
    fun isQuizEnded(): Boolean {
        return currentQuizIndex >= quizz.size
    }
    //Show the quiz question and answers
    fun getCurrentQuiz(): Quiz {
        return quizz[currentQuizIndex]
    }
}