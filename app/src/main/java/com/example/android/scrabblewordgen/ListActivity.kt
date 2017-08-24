package com.example.android.scrabblewordgen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout

class ListActivity : AppCompatActivity() {

    lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        mRecyclerView = findViewById(R.id.rv_numbers)
        val incomingIntent: Intent = intent
        val arrayList: ArrayList<String> = incomingIntent.getStringArrayListExtra("words")
        println("List activity madi")
        println(arrayList)
        val adapterObj = CustomAdapter(arrayList)
        mRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        mRecyclerView.adapter = adapterObj
    }
}
