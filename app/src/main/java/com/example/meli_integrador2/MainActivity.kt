package com.example.meli_integrador2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meli_integrador2.databinding.ActivityMainBinding
import com.example.meli_integrador2.utils.TextChangedListener
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.buttonStart.setOnClickListener {
            val intentToScreenActivities = Intent(this, Activities::class.java)
            intentToScreenActivities.putExtra(
                getString(R.string.key_number_participants),
                binding.editTextParticipants.text.toString()
            )
            startActivity(intentToScreenActivities)
        }

        binding.textViewTermsAndConditions.setOnClickListener {
            binding.layoutTerms.root.visibility = View.VISIBLE
        }
        binding.layoutTerms.ButtonTermsClose.setOnClickListener {
            binding.layoutTerms.root.visibility = View.GONE
        }
        binding.editTextParticipants.addTextChangedListener(
            TextChangedListener(
                binding.buttonStart,
                binding.editTextParticipants,
                this
            )
        )
    }
}