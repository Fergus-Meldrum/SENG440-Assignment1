package com.example.lorddapper

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectItem : AppCompatActivity() {

    private lateinit var optionPicker: RecyclerView

    private lateinit var options: ArrayList<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_item)

        options = intent.getStringArrayListExtra("options")

        var selection: String? = ""


        optionPicker = findViewById(R.id.optionPicker)
        val layoutManager = LinearLayoutManager(this)
        optionPicker.layoutManager = layoutManager

        optionPicker.adapter = OptionAdapter(this, options){
            selection = it
        }

        val decoration = DividerItemDecoration(this, layoutManager.orientation)
        optionPicker.addItemDecoration(decoration)

        val confirmSelectionButton: Button = findViewById(R.id.confirmSelectionButton)

        confirmSelectionButton.setOnClickListener {
            returnSelection(selection)
        }


    }

    fun returnSelection(selection: String?) {
        val result = Intent()
        result.putExtra("selection", selection)
        setResult(Activity.RESULT_OK, result)
        finish()
    }
}
