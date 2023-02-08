package com.chillcoding

class Quiz(var images: Int, var questions: String, var answer1 : String, var answer2 : String, var answer3 : String, var answer4 : String, var reponseTrue: Int){
    // If the response is correct return true
    fun isTrue(reponseNumber: Int) : Boolean {
        if (reponseNumber == reponseTrue)
            return true
        return false
    }
}

