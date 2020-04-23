package com.example.lorddapper

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

const val BRAND = 3

class choose_clothing_brand : Activity() {

    private var selection: String = ""

    private lateinit var brandDisplayText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_clothing_brand_3)

        var previousSelection: String = intent.getStringExtra("size_selection")

        val chooseBrandNextButton: Button = findViewById(R.id.chooseBrandNextButton)

        val chooseBrandButton: Button =  findViewById(R.id.chooseBrandButton)

        brandDisplayText = findViewById(R.id.brandDisplayText)

        val clothing_brands = arrayListOf("Gucci", "DKNY", "Prada", "Salvatore Ferragamo",
            "Stella McCartney", "Fendi", "Saint Laurent", "Givenchy", "Balmain",
            "Balenciaga", "Kenzo", "Alexander McQueen", "Louis Vuitton", "Giorgio Armani",
            "Tom Ford", "Berluti", "Burberry", "Comme Des Garçons", "Dior Homme",
            "Calvin Klein", "Brioni", "Ralph Lauren", "Valentino", "Paul Smith", "Ermenegildo Zegna",
            "Balenciaga", "Kenzo", "Alexander McQueen", "Louis Vuitton", "Giorgio Armani",
            "Hugo Boss", "DSquared2", "Thom Browne", "Hermes", "Lacoste")

        chooseBrandNextButton.setOnClickListener {
            val intent = Intent(this, choose_clothing_location::class.java)
            val formattedSelection: String = "$previousSelection $selection "
            intent.putExtra("brand_selection", formattedSelection)
            Toast.makeText(this, "Selection Saved!", Toast.LENGTH_SHORT).show()
            startActivity(intent)
            finish()
        }

        chooseBrandButton.setOnClickListener {
            val intent = Intent(this, SelectItem::class.java)
            intent.putExtra("options", clothing_brands)
            startActivityForResult(intent, BRAND)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == BRAND) {
            if (resultCode == RESULT_OK) {
                selection = data.getStringExtra("selection")
                brandDisplayText.text = selection
            }
        }
    }
}
