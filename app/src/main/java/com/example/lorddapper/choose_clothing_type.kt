package com.example.lorddapper

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

const val TYPE = 1

class choose_clothing_type : Activity() {

    private var selection: String = ""

    private lateinit var typeDisplayText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_clothing_type_1)

        val sellItem1NextButton: Button = findViewById(R.id.sellItem1NextButton)

        val chooseOptionButton: Button =  findViewById(R.id.chooseTypeButton)

        typeDisplayText = findViewById(R.id.typeDisplayText)


        val clothing_types = arrayListOf("Activewear", "Hoodies & Sweatshirts", "Jackets & Coats", "Jeans",
            "Joggers", "Jumpers & Cardigans", "Loungewear", "Polo shirts", "Shirts",
            "Shorts", "Socks", "Suits", "Swimwear", "T-Shirts & Vests", "Tracksuits & Joggers",
            "Trousers & Chinos", "Underwear")


        sellItem1NextButton.setOnClickListener {
            val intent = Intent(this, choose_clothing_size::class.java)
            val formattedSelection: String = "Mens $selection "
            intent.putExtra("type_selection", formattedSelection)
            Toast.makeText(this, "Selection Saved!", Toast.LENGTH_SHORT).show()
            startActivity(intent)
            finish()
        }

        chooseOptionButton.setOnClickListener {
            val intent = Intent(this, SelectItem::class.java)
            intent.putExtra("options", clothing_types)
            startActivityForResult(intent, TYPE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TYPE) {
            if (resultCode == RESULT_OK) {
                selection = data.getStringExtra("selection")
                typeDisplayText.text = selection
            }
        }
    }
}
