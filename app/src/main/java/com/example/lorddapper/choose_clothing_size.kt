package com.example.lorddapper

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

const val SIZE = 2

class choose_clothing_size : Activity() {

    private var selection: String = ""

    private lateinit var sizeDisplayText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_clothing_size_2)

        var previousSelection: String = intent.getStringExtra("type_selection")

        val chooseSizeNextButton: Button = findViewById(R.id.chooseSizeNextButton)

        val chooseOptionButton: Button =  findViewById(R.id.chooseSizeButton)

        sizeDisplayText = findViewById(R.id.sizeDisplayText)

        val clothing_sizes = arrayListOf("Small (S)", "Medium (M)", "Large (L)", "Extra Large (XL)",
            "Double Extra Large (XXL)")

        chooseSizeNextButton.setOnClickListener {
            val intent = Intent(this, choose_clothing_brand::class.java)
            val formattedSelection: String = "$previousSelection $selection "
            intent.putExtra("size_selection", formattedSelection)
            Toast.makeText(this, "Selection Saved!", Toast.LENGTH_SHORT).show()
            startActivity(intent)
            finish()
        }

        chooseOptionButton.setOnClickListener {
            val intent = Intent(this, SelectItem::class.java)
            intent.putExtra("options", clothing_sizes)
            startActivityForResult(intent, SIZE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SIZE) {
            if (resultCode == RESULT_OK) {
                selection = data.getStringExtra("selection")
                sizeDisplayText.text = selection
            }
        }
    }


}
