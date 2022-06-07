package com.example.meli_integrador2

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
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
            intentToScreenActivities.putExtra("", "") //TODO look at the putExtra
            startActivity(intentToScreenActivities)
        }

        binding.textViewTermsAndConditions.setOnClickListener {
           // binding.viewTermsAndConditions.visibility = View.VISIBLE
        }

        binding.editTextParticipants.addTextChangedListener(TextChangedListener(binding.buttonStart, binding.editTextParticipants, this))
    }
}