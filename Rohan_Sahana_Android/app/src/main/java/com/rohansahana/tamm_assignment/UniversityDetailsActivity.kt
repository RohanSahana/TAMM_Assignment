package com.rohansahana.tamm_assignment

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.rohansahana.tamm_assignment.utils.Constants.colors
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.rohansahana.tamm_assignment.models.University

class UniversityDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_university_details)

        // Retrieve the University object from intent extras
        val university = University(
            intent.getStringExtra("universityName") ?: "",
            intent.getStringExtra("universityAlphaTwoCode") ?: "",
            intent.getStringExtra("universityCountry") ?: "",
            intent.getStringArrayExtra("universityDomains")?.toList() ?: emptyList(),
            intent.getStringExtra("universityStateProvince"),
            intent.getStringArrayExtra("universityWebPages")?.toList() ?: emptyList()
        )

        val bgColor = intent.getIntExtra("bgColor", 0)
        // Create a CardView
        val cardView = createUniversityCardView(university, bgColor)

        // Get the parent layout where the CardView will be added
        val parentLayout = findViewById<RelativeLayout>(R.id.parentLayout)

        // Add the CardView to the parent layout
        parentLayout.addView(cardView)

        // Find the refresh button
        val refreshButton = findViewById<FloatingActionButton>(R.id.refreshButton)

        // Set OnClickListener for the refresh button
        refreshButton.setOnClickListener {
            // Refresh data here (call API again)
            refreshData()
        }
    }

    private fun refreshData() {
        // Redirect user to MainActivity
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
        // For demonstration purposes, let's just show a toast message
        Toast.makeText(this, "Data Refreshed", Toast.LENGTH_LONG).show()
    }

    private fun createUniversityCardView(university: University, bgColor: Int): CardView {
        val cardView = CardView(this)
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(16, 16, 16, 16)
        cardView.layoutParams = layoutParams
        cardView.cardElevation = 8f
        cardView.radius = 12f

        val gradientDrawable = ContextCompat.getDrawable(this, colors[bgColor])
        cardView.background = gradientDrawable

        cardView.setContentPadding(16, 16, 16, 16)

        val universityText = buildUniversityText(university)
        val textView = TextView(this)
        textView.text = universityText
        textView.setTypeface(null, Typeface.BOLD)
        textView.gravity = Gravity.CENTER_VERTICAL
        cardView.addView(textView)
        return cardView
    }

    private fun buildUniversityText(university: University): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("Name: ${university.name}\n")
        university.stateProvince?.let {
            stringBuilder.append("State/Province: $it\n")
        }
        stringBuilder.append("Country: ${university.country}\n")
        stringBuilder.append("Domains: ${university.domains.joinToString(", ")}\n")
        stringBuilder.append("Web Pages: ${university.webPages.joinToString(", ")}")
        return stringBuilder.toString()
    }
}
