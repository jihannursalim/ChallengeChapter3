package com.example.cobachallenge

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(private val words: List<Word>) :
    RecyclerView.Adapter<WordAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val word = words[position]
        holder.bind(word)
    }

    override fun getItemCount() = words.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvWord: TextView = itemView.findViewById(R.id.tv_word)

//        fun bind(word: Word) {
//            tvWord.text = word.word
//        }

        fun bind(word: Word) {
            tvWord.text = word.word
            tvWord.setOnClickListener {
                val query = "$word"
                val escapedQuery = Uri.encode(query)
                val url = "https://www.google.com/search?q=$escapedQuery"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                itemView.context.startActivity(intent)
            }
        }
    }
}
