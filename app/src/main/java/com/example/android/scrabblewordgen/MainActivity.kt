package com.example.android.scrabblewordgen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var tileKey: String

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
            tileKey = key

            // create an arrayList and fill it with the values of individual chars
            val al: ArrayList<Char> = ArrayList<Char>()
            for (i in 0..scrabbleTiles.length - 1) {
                al.add(scrabbleTiles.elementAt(i))
            }

            val scrabbleTilesLength = al.size

            for (i in 0..key.length - 1) {
                al.remove(key[i])
            }

            // check if the user input is correct in terms of a possibility of list of tiles
            if (al.size == scrabbleTilesLength - eKey.length) {
                println("This is a possibility")
            }

        }
// https://raw.githubusercontent.com/jonbcard/scrabble-bot/master/src/dictionary.txt
        // src for dictionary words


        val al: ArrayList<String> = ArrayList<String>()
        // check the file

        val file: File = File("C:\\Users\\MEA Mobile\\Documents\\ScrabbleWordGen\\app\\src\\main\\res\\dictionary.txt")
        val fileReader = FileReader(file)
        val bufferedReader = BufferedReader(fileReader)
        val word: String? = bufferedReader.readLine()
        while (word != null) {
            if (word.length >= 2 && word.length <= 7) {
                if(isInDictionary(word)){
                    al.add(word)
                }
            }
            else{
                continue
            }
        }
            println(al)
            bufferedReader.close()

        }
    fun isInDictionary(word: String): Boolean{

        val key: CharArray = tileKey.toCharArray()
        val arl: ArrayList<Char> = ArrayList()
        for(i in 0..tileKey.length-1){
            arl.add(tileKey[i])
        }

        for(i in 0..word.length-1){
            val c: Char = word[i]
            arl.remove(c)
        }

        if(arl.size == 7 - word.length){
            return true
        }

        return false
    }
    }

