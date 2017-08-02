package com.example.android.scrabblewordgen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TextView mTextView = findViewById(R.id.editText);
        val scrabbleTiles = "AAAAAAAAABBCCDDDDEEEEEEEEEEEEFFGGGHHIIIIIIIIIJKLLLLMMNNNNNNOOOOOOOOPPQRRRRRRSSSSTTTTTTUUUUVVWWXYYZ"
        println("Hwat " + scrabbleTiles.length)

        val button = findViewById<Button>(R.id.button)
        val view = findViewById<EditText>(R.id.editText)

        button.setOnClickListener {
            val eKey = view.text
            // println(key) print jhala
            val key: String = eKey.toString()


            // create an arrayList and fill it with the values of individual chars
            val al: ArrayList<Char> = ArrayList<Char>()
            for (i in 0..scrabbleTiles.length-1){
                al.add(scrabbleTiles.elementAt(i))
            }

            val scrabbleTilesLength = al.size

            for(i in 0..key.length-1){
                al.remove(key[i])
            }

            // check if the user input is correct in terms of a possibility of list of tiles
            if (al.size == scrabbleTilesLength - eKey.length){
                println("This is a possibility")
            }

        }
// https://raw.githubusercontent.com/jonbcard/scrabble-bot/master/src/dictionary.txt
        // src for dictionary words
    }
}
