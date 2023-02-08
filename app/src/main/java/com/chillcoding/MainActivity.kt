package com.chillcoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import android.content.res.Resources.getSystem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    // Define the layout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onClicked()
        Log.i(MainActivity::class.simpleName, getString(R.string.text_oncreate))
        // Show the recycler view link with the adapter
        val recyclerView = findViewById<RecyclerView>(R.id.beach_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = BeachAdapter(resources.getStringArray(R.array.name))
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
class BeachAdapter(private val beachList: Array<String>) :
    RecyclerView.Adapter<BeachAdapter.BeachViewHolder>() {

    class BeachViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
    // Return the list of beach
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeachViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false) as TextView
        return BeachViewHolder(textView)
    }

    override fun onBindViewHolder(holder: BeachViewHolder, position: Int) {
        holder.textView.text = beachList[position]
    }

    override fun getItemCount() = beachList.size
}