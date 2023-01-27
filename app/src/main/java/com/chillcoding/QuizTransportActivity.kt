package com.chillcoding

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class QuizTransportActivity: AppCompatActivity() {

    var quizz = ArrayList<Quiz>()
    var numberofGoodAnswers: Int = 0
    var currentQuizIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz2)

        quizz.add(Quiz(images = R.drawable.trans_q1, "Quel est la station manquante ?", "Passy", "Opéra", "Place d'Italie", "Reuilly Diderot", 3))
        quizz.add(Quiz(images = R.drawable.trans_q2, "Quel est le nom de ce train ?", "ICE", "TGV", "Shikansen", "AVE", 2))
        quizz.add(Quiz(images = R.drawable.trans_q3, "De quel pays vient ce train ?", "Italie", "Suisse", "Allemagne", "Autriche", 4))


        loadQuiz(quizz.get(currentQuizIndex))
    }



    fun loadQuiz(quiz: Quiz){
        val imageView = findViewById<ImageView>(R.id.imageView2)
        imageView.setImageResource(quizz.get(currentQuizIndex).images)
        findViewById<TextView>(R.id.textView_question).text =quiz.questions
        findViewById<RadioButton>(R.id.radio_answer1).text =quiz.answer1
        findViewById<RadioButton>(R.id.radio_answer2).text =quiz.answer2
        findViewById<RadioButton>(R.id.radio_answer3).text =quiz.answer3
        findViewById<RadioButton>(R.id.radio_answer4).text =quiz.answer4
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
            loadQuiz(quizz.get(currentQuizIndex))
        }
    }

    fun onClickAnswer(view: View){
        var radiogroup = findViewById<RadioGroup>(R.id.radioGroup)
        val selectedRadioButtonId: Int = radiogroup.checkedRadioButtonId
        when(selectedRadioButtonId){
            R.id.radio_answer1 -> handleAnswer(1)
            R.id.radio_answer2 -> handleAnswer(2)
            R.id.radio_answer3 -> handleAnswer(3)
            R.id.radio_answer4 -> handleAnswer(4)
        }
    }
}
