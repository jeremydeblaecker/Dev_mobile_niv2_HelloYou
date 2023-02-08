package com.chillcoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import android.content.res.Resources.getSystem
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {
    // Define the layout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onClicked()
        Log.i(MainActivity::class.simpleName, getString(R.string.text_oncreate))
    }
    // When mainButton is clicked show toast hi
    fun onClicked(){
        var button = findViewById<Button>(R.id.mainButton)
        button.setOnClickListener {
            Toast.makeText(this, getString(R.string.toast_msg), Toast.LENGTH_LONG).show()
        }
    }
    // Start Quiz 1
    fun onClickBtnPlay(view: View){
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }
    // Start Quiz 2
    fun onClickBtnQuiz(view: View){
        val intent = Intent(this, QuizTransportActivity::class.java)
        startActivity(intent)
    }
    // Methods for the lifecycle shown in the logcat
    override fun onRestart() {
        super.onRestart()
        Log.i(MainActivity::class.simpleName, getString(R.string.text_onrestart))
    }

    override fun onStart() {
        super.onStart()
        Log.i(MainActivity::class.simpleName, getString(R.string.text_onstart))
    }

    override fun onResume() {
        super.onResume()
        Log.i(MainActivity::class.simpleName, getString(R.string.text_onresume))
    }
    override fun onPause() {
        super.onPause()
        Log.i(MainActivity::class.simpleName, getString(R.string.text_onpause))
    }

    override fun onStop() {
        super.onStop()
        Log.i(MainActivity::class.simpleName, getString(R.string.text_onstop))
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(MainActivity::class.simpleName, getString(R.string.text_ondestroy))
    }
}