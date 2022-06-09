package com.example.meli_integrador2.ui

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meli_integrador2.databinding.ActivityMainBinding
import com.example.meli_integrador2.utils.TextChangedListener
import android.view.View
import com.example.meli_integrador2.R

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        visibilityTerms(View.VISIBLE)

        binding.layoutTerms.acceptTerms.setOnClickListener {
            visibilityTerms(View.GONE)
        }

        binding.buttonStart.setOnClickListener {
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

    private fun visibilityTerms(visibility: Int) {
        binding.layoutTerms.root.visibility = visibility
    }
}