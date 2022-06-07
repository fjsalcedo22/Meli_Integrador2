package com.example.meli_integrador2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meli_integrador2.databinding.ActivityMainBinding
import com.example.meli_integrador2.utils.TextChangedListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.buttonStart.setOnClickListener {
            val intentToScreenActivities = Intent(this, Activities::class.java)
            intentToScreenActivities.putExtra(getString(R.string.key_number_participants), binding.editTextParticipants.text) //TODO look at the putExtra
            startActivity(intentToScreenActivities)
        }

        binding.textViewTermsAndConditions.setOnClickListener {
           // binding.viewTermsAndConditions.visibility = View.VISIBLE
        }

        binding.editTextParticipants.addTextChangedListener(TextChangedListener(binding.buttonStart, binding.editTextParticipants, this))
    }
}