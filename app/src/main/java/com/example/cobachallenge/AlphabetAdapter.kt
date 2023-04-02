package com.example.cobachallenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlphabetAdapter(private val listener: OnItemClickListener) :
    RecyclerView.Adapter<AlphabetAdapter.ViewHolder>() {

    private val alphabets = ('A'..'J').map { it.toString() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_alphabet, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val alphabet = alphabets[position]
        holder.bind(alphabet, listener)
    }

    override fun getItemCount() = alphabets.size

    interface OnItemClickListener {
        fun onItemClick(alphabet: String)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvAlphabet: TextView = itemView.findViewById(R.id.tv_alphabet)

        fun bind(alphabet: String, listener: OnItemClickListener) {
            tvAlphabet.text = alphabet
            itemView.setOnClickListener { listener.onItemClick(alphabet) }
        }
    }
}
