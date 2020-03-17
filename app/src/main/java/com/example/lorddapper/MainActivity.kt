package com.example.lorddapper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**Called when the users presses the 'Go' button */
    fun searchDesigns(view: View) {
        val intent = Intent(this, SearchResultsActivity::class.java)
    })
}
