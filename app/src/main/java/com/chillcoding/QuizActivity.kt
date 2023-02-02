package com.chillcoding

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.chillcoding.R.layout.activity_quiz

class QuizActivity : AppCompatActivity() {

    var quizz = ArrayList<Quiz>()
    var numberofGoodAnswers: Int = 0
    var currentQuizIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_quiz)

        quizz.add(Quiz(images = R.drawable.aus,getString(R.string.question_1), getString(R.string.q1_a1), getString(R.string.q1_a2), getString(R.string.q1_a3), getString(R.string.q1_a4), 1))
        quizz.add(Quiz(images = R.drawable.turk,getString(R.string.question_2), getString(R.string.q2_a1),  getString(R.string.q2_a2),  getString(R.string.q2_a3),  getString(R.string.q2_a4), 3))
        quizz.add(Quiz(images = R.drawable.india,getString(R.string.question_3), getString(R.string.q3_a1), getString(R.string.q3_a2), getString(R.string.q3_a3), getString(R.string.q3_a4), 4))
        quizz.add(Quiz(images = R.drawable.brand,getString(R.string.question_4), getString(R.string.q4_a1), getString(R.string.q4_a2), getString(R.string.q4_a3), getString(R.string.q4_a4), 2))

        showQuestion(quizz.get(currentQuizIndex))

    }

    fun showQuestion(quiz: Quiz){
        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(quizz.get(currentQuizIndex).images)
        findViewById<TextView>(R.id.questions).text =quiz.questions
        findViewById<TextView>(R.id.answer1).text =quiz.answer1
        findViewById<TextView>(R.id.answer2).text =quiz.answer2
        findViewById<TextView>(R.id.answer3).text =quiz.answer3
        findViewById<TextView>(R.id.answer4).text =quiz.answer4

    }
    fun handleAnswer(answerID : Int){
        val quiz = quizz.get(currentQuizIndex)
        if (quiz.isTrue(answerID)){
            numberofGoodAnswers++
            Toast.makeText(this,getString(R.string.ans_true), Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,getString(R.string.ans_false), Toast.LENGTH_SHORT).show()
        }
        // Go to next question
        currentQuizIndex++
        if (currentQuizIndex>= quizz.size){
            var alert = AlertDialog.Builder(this)
            alert.setTitle(getString(R.string.end))
            alert.setMessage(getString(R.string.result) + numberofGoodAnswers + getString(R.string.points))
            alert.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, id -> finish()})
            alert.show()
        }else{
            showQuestion(quizz.get(currentQuizIndex))
        }
    }
    fun onClickAnswer1(view: View) { handleAnswer(1) }
    fun onClickAnswer2(view: View) { handleAnswer(2) }
    fun onClickAnswer3(view: View) { handleAnswer(3) }
    fun onClickAnswer4(view: View) { handleAnswer(4) }

}