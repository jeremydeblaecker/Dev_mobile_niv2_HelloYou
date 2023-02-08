package com.chillcoding.ui.quiz1

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.chillcoding.Quiz
import com.chillcoding.R
import com.chillcoding.databinding.FragmentQuiz1Binding
import com.chillcoding.ui.home.HomeFragment

class Quiz1Fragment : Fragment() {
    private var _binding: FragmentQuiz1Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var quizz = ArrayList<Quiz>()
    var numberofGoodAnswers: Int = 0
    var currentQuizIndex: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuiz1Binding.inflate(inflater, container, false)
        val root: View = binding.root

        //Define questions, images, answers and response
        quizz.add(Quiz(images = R.drawable.aus,getString(R.string.question_1), getString(R.string.q1_a1), getString(R.string.q1_a2), getString(R.string.q1_a3), getString(R.string.q1_a4), 1))
        quizz.add(Quiz(images = R.drawable.turk,getString(R.string.question_2), getString(R.string.q2_a1),  getString(R.string.q2_a2),  getString(R.string.q2_a3),  getString(R.string.q2_a4), 3))
        quizz.add(Quiz(images = R.drawable.india,getString(R.string.question_3), getString(R.string.q3_a1), getString(R.string.q3_a2), getString(R.string.q3_a3), getString(R.string.q3_a4), 4))
        quizz.add(Quiz(images = R.drawable.brand,getString(R.string.question_4), getString(R.string.q4_a1), getString(R.string.q4_a2), getString(R.string.q4_a3), getString(R.string.q4_a4), 2))

        //Check answers when text with onClickListener is pressed
        binding.answer1.setOnClickListener { handleAnswer(1) }
        binding.answer2.setOnClickListener { handleAnswer(2) }
        binding.answer3.setOnClickListener { handleAnswer(3) }
        binding.answer4.setOnClickListener { handleAnswer(4) }
        showQuestion(quizz[currentQuizIndex])
        return root
    }
    //Show image, questions, responses depending on the actual index question
    fun showQuestion(quiz: Quiz){
        val imageView = binding.imageView
        imageView.setImageResource(quizz.get(currentQuizIndex).images)
        binding.questions.text =quiz.questions
        binding.answer1.text =quiz.answer1
        binding.answer2.text =quiz.answer2
        binding.answer3.text =quiz.answer3
        binding.answer4.text =quiz.answer4
    }
    //Show if the result is good or bad
    private fun handleAnswer(answerID: Int) {
        val quiz = quizz[currentQuizIndex]
        if (quiz.isTrue(answerID)) {
            numberofGoodAnswers++
            Toast.makeText(requireContext(), getString(R.string.ans_true), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), getString(R.string.ans_false), Toast.LENGTH_SHORT).show()
        }
        // Count the number of points depending on the number of good response clicked
        currentQuizIndex++
        if (currentQuizIndex >= quizz.size) {
            val alert = AlertDialog.Builder(requireContext())
            alert.setTitle(getString(R.string.end))
            alert.setMessage(
                getString(R.string.result) + numberofGoodAnswers + getString(R.string.points)
            )
            // When the quiz is finished show a button with OK to go to the Home page
            alert.setPositiveButton("OK") { _, _ ->
                val homeFragment = HomeFragment()
                val fragmentManager = requireActivity().supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.container, homeFragment)
                fragmentTransaction.commit()
            }
            alert.show()

        } else {
            showQuestion(quizz[currentQuizIndex])
        }
    }
    //Destroy the view once the quiz is finished
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    // Methods shown in the logcat depending on the state of the activity
    override fun onStart() {
        super.onStart()
        Log.i(Quiz1Fragment::class.simpleName, getString(R.string.text_onstart))
    }

    override fun onResume() {
        super.onResume()
        Log.i(Quiz1Fragment::class.simpleName, getString(R.string.text_onresume))
    }
    override fun onPause() {
        super.onPause()
        Log.i(Quiz1Fragment::class.simpleName, getString(R.string.text_onpause))
    }

    override fun onStop() {
        super.onStop()
        Log.i(Quiz1Fragment::class.simpleName, getString(R.string.text_onstop))
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(Quiz1Fragment::class.simpleName, getString(R.string.text_ondestroy))
    }

}