package com.chillcoding.ui.quiz2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.chillcoding.Quiz
import com.chillcoding.R
import com.chillcoding.databinding.FragmentQuiz2Binding

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

        quizz.add(Quiz(images = R.drawable.trans_q1, getString(R.string.question_1_q2), getString(R.string.q2_a1_1), getString(R.string.q2_a1_2), getString(R.string.q2_a1_3), getString(R.string.q2_a1_4), 3))
        quizz.add(Quiz(images = R.drawable.trans_q2, getString(R.string.question_2_q2), getString(R.string.q2_a2_1), getString(R.string.q2_a2_2), getString(R.string.q2_a2_3), getString(R.string.q2_a2_4), 2))
        quizz.add(Quiz(images = R.drawable.trans_q3, getString(R.string.question_3_q2), getString(R.string.q2_a3_1), getString(R.string.q2_a3_2), getString(R.string.q2_a3_3), getString(R.string.q2_a2_4), 4))

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                binding.radioAnswer1.id -> handleAnswer(1)
                binding.radioAnswer2.id -> handleAnswer(2)
                binding.radioAnswer3.id -> handleAnswer(3)
                binding.radioAnswer4.id -> handleAnswer(4)
            }
        }
        showQuestion(quizz[currentQuizIndex])
        return root
    }

    fun showQuestion(quiz: Quiz){
        val imageView = binding.imageView2
        imageView.setImageResource(quizz.get(currentQuizIndex).images)
        binding.textViewQuestion.text = quiz.questions
        binding.radioAnswer1.text =quiz.answer1
        binding.radioAnswer2.text =quiz.answer2
        binding.radioAnswer3.text =quiz.answer3
        binding.radioAnswer4.text =quiz.answer4
    }
    private fun handleAnswer(answerID: Int) {
        val quiz = quizz[currentQuizIndex]
        if (quiz.isTrue(answerID)) {
            numberofGoodAnswers++
            Toast.makeText(requireContext(), getString(R.string.ans_true), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), getString(R.string.ans_false), Toast.LENGTH_SHORT).show()
        }

        currentQuizIndex++
        if (currentQuizIndex >= quizz.size) {
            val alert = android.app.AlertDialog.Builder(requireContext())
            alert.setTitle(getString(R.string.end))
            alert.setMessage(
                getString(R.string.result) + numberofGoodAnswers + getString(R.string.points)
            )
            alert.setPositiveButton("OK") { _, _ -> requireActivity().finish() }
            alert.show()
        } else {
            showQuestion(quizz[currentQuizIndex])
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}