package com.chillcoding.ui.quiz2

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.chillcoding.Quiz
import com.chillcoding.R
import com.chillcoding.databinding.FragmentQuiz2Binding
import com.chillcoding.ui.home.HomeFragment

class Quiz2Fragment : Fragment() {

    private var _binding: FragmentQuiz2Binding? = null
    var quizz = ArrayList<Quiz>()
    var numberofGoodAnswers: Int = 0
    var currentQuizIndex: Int = 0
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuiz2Binding.inflate(inflater, container, false)
        val root: View = binding.root
        //Define questions, images, answers and response
        quizz.add(Quiz(images = R.drawable.trans_q1, getString(R.string.question_1_q2), getString(R.string.q2_a1_1), getString(R.string.q2_a1_2), getString(R.string.q2_a1_3), getString(R.string.q2_a1_4), 3))
        quizz.add(Quiz(images = R.drawable.trans_q2, getString(R.string.question_2_q2), getString(R.string.q2_a2_1), getString(R.string.q2_a2_2), getString(R.string.q2_a2_3), getString(R.string.q2_a2_4), 2))
        quizz.add(Quiz(images = R.drawable.trans_q3, getString(R.string.question_3_q2), getString(R.string.q2_a3_1), getString(R.string.q2_a3_2), getString(R.string.q2_a3_3), getString(R.string.q2_a2_4), 4))

        //Check answers when radio button is clicked and 'Answer' button is pressed
        binding.button.setOnClickListener {
            val selectedAnswer = binding.radioGroup.checkedRadioButtonId
            var answer = 0
            when (selectedAnswer) {
                binding.radioAnswer1.id -> answer = 1
                binding.radioAnswer2.id -> answer = 2
                binding.radioAnswer3.id -> answer = 3
                binding.radioAnswer4.id -> answer = 4
            }
            handleAnswer(answer)
        }
        showQuestion(quizz[currentQuizIndex])
        return root
    }
    //Show image, questions, responses depending on the actual index question
    fun showQuestion(quiz: Quiz){
        val imageView = binding.imageView2
        imageView.setImageResource(quizz.get(currentQuizIndex).images)
        binding.textViewQuestion.text = quiz.questions
        binding.radioAnswer1.text =quiz.answer1
        binding.radioAnswer2.text =quiz.answer2
        binding.radioAnswer3.text =quiz.answer3
        binding.radioAnswer4.text =quiz.answer4
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
}