package com.example.lorddapper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sellButton: Button = findViewById(R.id.sellButton)

        sellButton.setOnClickListener {
            val intent = Intent(this, Sell_Item1::class.java)
            startActivity(intent)
        }

        val goButton: Button = findViewById(R.id.goButton)

        goButton.setOnClickListener {
            val intent = Intent(this, BrowseItems::class.java)
            startActivity(intent)
        }
    }
}
