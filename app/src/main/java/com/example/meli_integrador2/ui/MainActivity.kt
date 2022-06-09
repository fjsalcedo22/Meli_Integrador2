package com.example.meli_integrador2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meli_integrador2.databinding.ActivityMainBinding
import com.example.meli_integrador2.utils.TextChangedListener
import android.view.View
import com.example.meli_integrador2.R


/**
 - ScreenHome
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        visibilityTerms(View.VISIBLE) // make terms and conditions visible as soon as you start the application and must it to be able to navigate.

        binding.layoutTerms.acceptTerms.setOnClickListener { // listener that listens when you accept the terms and conditions and be able to navigate
            visibilityTerms(View.GONE)
        }

        binding.buttonStart.setOnClickListener { // listener that listens for the start button to navigate to the activity (Activities) and send the collected information
            val intentToScreenActivities = Intent(this, Activities::class.java)
            intentToScreenActivities.putExtra(
                getString(R.string.key_number_participants),
                binding.editTextParticipants.text.toString()
            )
            intentToScreenActivities.putExtra(
                getString(R.string.key_price),
                binding.editTextPrice.text.toString()
            )
            startActivity(intentToScreenActivities)
        }

        // property is added to the editText editTextParticipants and editTextPrice  which calls the class TextChangedListener who listens to what is write

        binding.editTextParticipants.addTextChangedListener(
            TextChangedListener(
                binding.buttonStart,
                binding.editTextParticipants,
                this,
                binding

            )
        )

        binding.editTextPrice.addTextChangedListener(
            TextChangedListener(
                binding.buttonStart,
                binding.editTextPrice,
                this,
                binding
            )
        )
    }

    private fun visibilityTerms(visibility: Int) {  // put the visibility at layout Terms and conditions
        binding.layoutTerms.root.visibility = visibility
    }
}