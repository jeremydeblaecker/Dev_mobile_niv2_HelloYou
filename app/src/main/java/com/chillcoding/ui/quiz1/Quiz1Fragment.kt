package com.chillcoding.ui.quiz1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.chillcoding.Quiz
import com.chillcoding.R
class Quiz1Fragment : Fragment() {
    private lateinit var quiz1ViewModel: Quiz1ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        quiz1ViewModel = ViewModelProvider(this).get(Quiz1ViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_quiz1, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quiz1ViewModel.quizz.observe(viewLifecycleOwner, Observer {
            it?.let {
                showQuestion(it)
            }
        })
    }

    fun showQuestion(quiz: Quiz){
        val imageView = view?.findViewById<ImageView>(R.id.imageView)
        imageView?.setImageResource(quiz.images)
        view?.findViewById<TextView>(R.id.questions)?.text = quiz.questions
        view?.findViewById<TextView>(R.id.answer1)?.text = quiz.answer1
        view?.findViewById<TextView>(R.id.answer2)?.text = quiz.answer2
        view?.findViewById<TextView>(R.id.answer3)?.text = quiz.answer3
        view?.findViewById<TextView>(R.id.answer4)?.text = quiz.answer4
    }

    fun handleAnswer(answerID : Int){
        quiz1ViewModel.handleAnswer(answerID)
    }

    fun onClickAnswer1(view: View) { handleAnswer(1) }
    fun onClickAnswer2(view: View) { handleAnswer(2) }
    fun onClickAnswer3(view: View) { handleAnswer(3) }
    fun onClickAnswer4(view: View) { handleAnswer(4) }

}