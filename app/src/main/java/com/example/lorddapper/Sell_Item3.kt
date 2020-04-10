package com.example.lorddapper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Sell_Item3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell__item3)

        val sellItem3NextButton: Button = findViewById(R.id.sellItem3NextButton)

        sellItem3NextButton.setOnClickListener {
            finish()
        }
    }
}
