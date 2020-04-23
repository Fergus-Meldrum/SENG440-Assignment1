package com.example.lorddapper

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OptionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val optionText: TextView = view.findViewById(R.id.optionText)

    var isActive: Boolean = false
        set(value) {
            field = value
            itemView.setBackgroundColor(if (field) Color.LTGRAY else Color.TRANSPARENT)
        }

}
