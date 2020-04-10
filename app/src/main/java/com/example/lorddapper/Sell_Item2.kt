package com.example.lorddapper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageButton

class Sell_Item2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell__item2)

        val sellItem2NextButton: Button = findViewById(R.id.sellItem2NextButton)

        sellItem2NextButton.setOnClickListener {
            val intent = Intent(this, Sell_Item3::class.java)
            startActivity(intent)
            finish()
        }

        val takePhotoButton: ImageButton = findViewById(R.id.takePhotoButton)

        takePhotoButton.setOnClickListener {
            dispatchTakePictureIntent()
        }

    }

    //code from Android Developers site:
    val REQUEST_IMAGE_CAPTURE = 1

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }
}
