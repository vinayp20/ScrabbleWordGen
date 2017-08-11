package com.example.android.scrabblewordgen

import android.content.Intent
import android.content.res.AssetManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import java.io.*


class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private var tileKey: String = ""

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
            val alChar: ArrayList<Char> = ArrayList<Char>()
            for (i in 0..scrabbleTiles.length - 1) {
                alChar.add(scrabbleTiles.elementAt(i))
            }

            val scrabbleTilesLength = alChar.size

            for (i in 0..key.length - 1) {
                alChar.remove(key[i])
            }

            // check if the user input is correct in terms of a possibility of list of tiles
            if (alChar.size == scrabbleTilesLength - eKey.length) {
                println("This is a possibility")
            }


// https://raw.githubusercontent.com/jonbcard/scrabble-bot/master/src/dictionary.txt
        // src for dictionary words


        val al: ArrayList<String> = ArrayList<String>()
        // check the file

        //  val file: File = File("C:\\Users\\MEA Mobile\\Documents\\ScrabbleWordGen\\app\\src\\main\\res\\dictionary.txt")
        val am: AssetManager = this.assets

        val fileInputStreamReader: InputStream = am.open("dictionary.txt")
        val inputStreamReader: InputStreamReader = InputStreamReader(fileInputStreamReader)
        val bufferedReader = BufferedReader(inputStreamReader)
        var word: String = ""
        var i: Int = 0
        while (i < 178691){
            word = bufferedReader.readLine()
         //   println(word)
            if (word.length >= 2 && word.length <= 7) {
                if (isInDictionary(word)) {
                    al.add(word)
                }
            }
            i++
        }
             println(al)
            println(al.size)
            bufferedReader.close()
            val intent: Intent = Intent(applicationContext, ListActivity::class.java)
            intent.putStringArrayListExtra("words", al)
            startActivity(intent)
        }
    }
    fun isInDictionary(word: String): Boolean{


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


