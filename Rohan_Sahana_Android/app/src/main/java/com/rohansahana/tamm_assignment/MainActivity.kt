package com.rohansahana.tamm_assignment

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rohansahana.tamm_assignment.models.University
import com.rohansahana.tamm_assignment.utils.Constants.colors
import com.rohansahana.tamm_assignment.viewmodels.MainViewModel
import com.rohansahana.tamm_assignment.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private lateinit var universitiesLayout: LinearLayout

    private var colorIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the layout of the activity
        setContentView(R.layout.activity_main)
        // Inject dependencies using Dagger
        (application as UniversityApplication).applicationComponent.inject(this)
        
        // MultiBinding Implementation
        val map = (application as UniversityApplication).applicationComponent.getMap()

        // Initialize ViewModel using ViewModelProvider and Dagger's ViewModelFactory
        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]
        // Initialize LinearLayout
        universitiesLayout = findViewById(R.id.universities)
        // Observe the LiveData in the ViewModel for universities
        mainViewModel.universityLiveData.observe(this, Observer { universities ->
            Log.d("Main Activity", universities.toString())
            if (universities.isNullOrEmpty()) {
                // Show a toast message indicating data retrieval failure
                Toast.makeText(this, "Failed to retrieve University data", Toast.LENGTH_SHORT).show()
                val errorMessageTextView = TextView(this)
                errorMessageTextView.text = "Failed to retrieve University data"
                errorMessageTextView.setTextColor(Color.RED)

                universitiesLayout.addView(errorMessageTextView)

            } else {
                // Loop through each university in the list
                universities.forEach { university ->
                    // Create a new CardView to display the university data
                    val cardView = createUniversityCardView(university, colors[colorIndex])
                    // Add the CardView to the LinearLayout to display on the screen
                    universitiesLayout.addView(cardView)
                    // Set click listener for each university CardView
                    cardView.setOnClickListener {
                        navigateToDetailsScreen(university, colorIndex)
                    }
                    colorIndex = (colorIndex + 1) % colors.size
                }
            }
        })
    }

    private fun createUniversityCardView(university: University, bg: Int): CardView {
        val cardView = CardView(this)
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(16, 16, 16, 16)
        cardView.layoutParams = layoutParams
        cardView.cardElevation = 8f
        cardView.radius = 12f

        val gradientDrawable = ContextCompat.getDrawable(this, bg)
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
//        stringBuilder.append("Country: ${university.country}\n")
//        stringBuilder.append("Domains: ${university.domains.joinToString(", ")}\n")
//        stringBuilder.append("Web Pages: ${university.webPages.joinToString(", ")}")
        return stringBuilder.toString()
    }

    private fun navigateToDetailsScreen(university: University, bg: Int) {
//        val alertDialogBuilder = AlertDialog.Builder(this)
//        alertDialogBuilder.setTitle("University Details")
//        alertDialogBuilder.setMessage(buildUniversityText(university))
//        alertDialogBuilder.setPositiveButton("OK") { dialog, _ ->
//            dialog.dismiss()
//        }
//        val alertDialog = alertDialogBuilder.create()
//        alertDialog.show()
        val intent = Intent(this, UniversityDetailsActivity::class.java)
        intent.putExtra("universityName", university.name)
        intent.putExtra("universityAlphaTwoCode", university.alphaTwoCode)
        intent.putExtra("universityCountry", university.country)
        intent.putExtra("universityDomains", university.domains.toTypedArray())
        intent.putExtra("universityStateProvince", university.stateProvince)
        intent.putExtra("universityWebPages", university.webPages.toTypedArray())
        intent.putExtra("bgColor", colorIndex)
        startActivity(intent)
    }
}
