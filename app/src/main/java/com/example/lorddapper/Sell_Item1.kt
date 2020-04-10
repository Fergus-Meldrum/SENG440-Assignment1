package com.example.lorddapper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Sell_Item1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell__item1)

        val sellItem1NextButton: Button = findViewById(R.id.sellItem1NextButton)

        sellItem1NextButton.setOnClickListener {
            val intent = Intent(this, Sell_Item2::class.java)
            startActivity(intent)
            finish()
        }
    }
}
