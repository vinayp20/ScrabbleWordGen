package com.example.android.scrabblewordgen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val incomingIntent: Intent = intent
        val arrayList: ArrayList<String> = incomingIntent.getStringArrayListExtra("words")
        println("List activity madi")
        println(arrayList)
    }
}
