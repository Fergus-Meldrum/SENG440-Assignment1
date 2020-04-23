package com.example.lorddapper

import android.app.Activity
import android.app.SearchManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

const val LOCATION = 4

class choose_clothing_location : Activity() {

    private var selection: String = ""

    private lateinit var locationDisplayText: TextView

    private lateinit var finalSearchText: TextView

    private lateinit var previousSelection: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_clothing_location_4)

        finalSearchText = findViewById(R.id.final_search_text)
        previousSelection = intent.getStringExtra("brand_selection")
        finalSearchText.text = previousSelection

        val searchButton: Button = findViewById(R.id.searchButton)

        val chooseLocationButton: Button =  findViewById(R.id.chooseLocationButton)

        locationDisplayText = findViewById(R.id.locationDisplayText)


        val locations = arrayListOf("Auckland", "Wellington", "Christchurch", "Hamilton",
            "Tauranga", "Napier / Hastings", "Dunedin", "Palmerston North", "New Plymouth",
            "Nelson")


        searchButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
                putExtra(SearchManager.QUERY, finalSearchText.text.toString())
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        chooseLocationButton.setOnClickListener {
            val intent = Intent(this, SelectItem::class.java)
            intent.putExtra("options", locations)
            startActivityForResult(intent, LOCATION)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == LOCATION) {
            if (resultCode == RESULT_OK) {
                selection = data.getStringExtra("selection")
                locationDisplayText.text = selection
                finalSearchText.text = "$previousSelection $selection"
            }
        }
    }
}
