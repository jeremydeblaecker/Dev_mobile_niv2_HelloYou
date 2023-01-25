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
import java.net.InterfaceAddress

class QuizActivity : AppCompatActivity() {

    var quizz = ArrayList<Quiz>()
    var numberofGoodAnswers: Int = 0
    var currentQuizIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_quiz)

        quizz.add(Quiz(images = R.drawable.aus,"Quelle est la capitale de l'Australie", "Canberra", "Melbourne", "Sydney", "Adélaïde", 1))
        quizz.add(Quiz(images = R.drawable.turk,"Quelle est ce pays ?", "Ouzbékistan", "Kirghizistan", "Turkménistan", "Tadjikistan", 3))
        quizz.add(Quiz(images = R.drawable.india,"Quelle est la capitale de l'Inde", "Mumbai", "Bombay", "Calcuta", "New Delhi", 4))
        quizz.add(Quiz(images = R.drawable.brand,"Quelle est ce monument ?", "L'Arc de Constantin", "La Porte de Brandebourg", "L'Arc de triomphe de l'Étoile", "L'Arc de Titus", 2))

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
            Toast.makeText(this,"+1 bonne réponse", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Mauvaise réponse", Toast.LENGTH_SHORT).show()
        }
        // Go to next question
        currentQuizIndex++
        if (currentQuizIndex>= quizz.size){
            var alert = AlertDialog.Builder(this)
            alert.setTitle("Partie terminé!")
            alert.setMessage("Résultat : " + numberofGoodAnswers + " point(s)")
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