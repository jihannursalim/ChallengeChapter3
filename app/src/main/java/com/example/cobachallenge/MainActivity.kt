package com.example.cobachallenge

import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class MainActivity : AppCompatActivity(), AlphabetAdapter.OnItemClickListener {

    private lateinit var alphabetAdapter: AlphabetAdapter
    private lateinit var wordAdapter: WordAdapter
    private lateinit var rvAlphabets: RecyclerView
    private lateinit var words: List<Word>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAlphabets = findViewById(R.id.rv_alphabets)
        alphabetAdapter = AlphabetAdapter(this)
        rvAlphabets.adapter = alphabetAdapter

        words = listOf(
            Word("Ayam"), Word("Buaya"), Word("Cicak"), Word("Domba"), Word("Elang"),
            Word("Flamingo"), Word("Gajah"), Word("Harimau"), Word("Iguana"), Word("Jerapah")
        )

        //Membuat tata letak
        val lm = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvAlphabets.layoutManager = lm
    }

    override fun onItemClick(alphabet: String) {
//        val words = mutableListOf<Word>()
//        for (i in 1..3) {
//            words.add(Word("$alphabet-word$i"))
//        }
//        wordAdapter = WordAdapter(words)
//        rvAlphabets.apply {
//            adapter = wordAdapter
//        }

        val words = mutableListOf<Word>()
        try {
            val inputStream = assets.open("words.txt")
            val reader = BufferedReader(InputStreamReader(inputStream))
            var line: String? = reader.readLine()
            while (line != null) {
                if (line.startsWith(alphabet, ignoreCase = true)) {
                    words.add(Word(line))
                }
                line = reader.readLine()
            }
        } catch (e: IOException) {
            Log.e(TAG, "Failed to read words file", e)
            return
        }
        wordAdapter = WordAdapter(words)
        rvAlphabets.apply {
            adapter = wordAdapter
        }

//        val query = "kata yang ingin dicari"
//        val url = "https://www.google.com/search?q=$query"
//        val intent = Intent(Intent.ACTION_VIEW)
//        intent.data = Uri.parse(url)
//        startActivity(intent)

    }
    }


//    private fun onAlphabetClicked(alphabet: Char) {
//        val words = mutableListOf<Word>()
//        for (i in 1..3) {
//            words.add(Word("$alphabet-word$i", alphabet))
//        }
//        wordAdapter = WordAdapter(words)
//        rvAlphabets.apply {
//            adapter = wordAdapter
//        }
//    }




