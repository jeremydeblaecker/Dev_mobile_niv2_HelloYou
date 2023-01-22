package com.chillcoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import android.content.res.Resources.getSystem
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onClicked()
        Log.i(MainActivity::class.simpleName, getString(R.string.text_oncreate))
    }

    fun onClicked(){
        var button = findViewById<Button>(R.id.mainButton)
        button.setOnClickListener {
            Toast.makeText(this, getString(R.string.toast_msg), Toast.LENGTH_LONG).show()
        }
    }
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