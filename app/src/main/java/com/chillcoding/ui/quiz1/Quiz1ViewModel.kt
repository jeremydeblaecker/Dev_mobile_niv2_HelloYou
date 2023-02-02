package com.chillcoding.ui.quiz1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chillcoding.Quiz
import com.chillcoding.R

class Quiz1ViewModel : ViewModel() {

    val quizz = MutableLiveData<ArrayList<Quiz>>()
    val numberofGoodAnswers = MutableLiveData<Int>(0)
    val currentQuizIndex = MutableLiveData<Int>(0)

    init {
        val quizList = ArrayList<Quiz>()
        quizList.add(Quiz(images = R.drawable.aus, getString(R.string.question_1), getString(R.string.q1_a1), getString(R.string.q1_a2), getString(R.string.q1_a3), getString(R.string.q1_a4), 1))
        quizList.add(Quiz(images = R.drawable.turk, getString(R.string.question_2), getString(R.string.q2_a1), getString(R.string.q2_a2), getString(R.string.q2_a3), getString(R.string.q2_a4), 3))
        quizList.add(Quiz(images = R.drawable.india, getString(R.string.question_3), getString(R.string.q3_a1), getString(R.string.q3_a2), getString(R.string.q3_a3), getString(R.string.q3_a4), 4))
        quizList.add(Quiz(images = R.drawable.brand, getString(R.string.question_4), getString(R.string.q4_a1), getString(R.string.q4_a2), getString(R.string.q4_a3), getString(R.string.q4_a4), 2))
        quizz.value = quizList
    }

    fun handleAnswer(answerID : Int){
        val currentIndex = currentQuizIndex.value ?: return
        val quiz = quizz.value?.get(currentIndex) ?: return
        if (quiz.isTrue(answerID)){
            numberofGoodAnswers.value = (numberofGoodAnswers.value ?: 0) + 1
        }
        // Go to next question
        currentQuizIndex.value = (currentIndex + 1)
    }

}