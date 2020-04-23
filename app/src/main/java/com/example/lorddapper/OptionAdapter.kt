package com.example.lorddapper

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class OptionAdapter(val context: Context,
                     val options: ArrayList<String>,
                    val clickListener: (String) -> Unit): RecyclerView.Adapter<OptionViewHolder>() {

    private var selectedIndex = RecyclerView.NO_POSITION

    override fun getItemCount(): Int = options.size

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): OptionViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.list_holder, parent, false)
        val holder = OptionViewHolder(view)
        view.setOnClickListener {
            clickListener(options[holder.adapterPosition])
            val oldSelectedIndex = selectedIndex
            selectedIndex = holder.adapterPosition
            notifyItemChanged(selectedIndex)
            notifyItemChanged(oldSelectedIndex)

        }

        return holder
    }

    override fun onBindViewHolder(holder: OptionViewHolder, i: Int) {
        holder.optionText.text = options[i]
        holder.isActive = selectedIndex == i
    }
}
