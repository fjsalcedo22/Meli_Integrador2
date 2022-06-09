package com.example.meli_integrador2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meli_integrador2.R
import com.example.meli_integrador2.databinding.ActivityActivitiesBinding
import com.example.meli_integrador2.interfaces.OnItemClickListener
import com.example.meli_integrador2.recycler.AdapterActivities

class Activities : AppCompatActivity(), OnItemClickListener {
    private lateinit var binding: ActivityActivitiesBinding
    private lateinit var adapter: AdapterActivities
    private lateinit var participants: String
    private lateinit var price: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val list = resources.getStringArray(R.array.list_activities)
        adapter = AdapterActivities(list, this)
        binding.recyclerActivities.layoutManager = LinearLayoutManager(this)
        binding.recyclerActivities.adapter = adapter

        binding.imageButtonRandom.setOnClickListener {
            intentToScreenTips()
        }

    }

    override fun onResume() {
        super.onResume()
        participants = intent.getStringExtra(getString(R.string.key_number_participants)).toString()
        price = intent.getStringExtra(getString(R.string.key_price)).toString()
    }

    override fun onItemClick(category: String) {
        intentToScreenTips(category)
    }

    private fun intentToScreenTips(category: String? = null) {
        val intent = Intent(this, ScreenTips::class.java)
        intent.putExtra(getString(R.string.key_number_participants), participants)
        intent.putExtra(getString(R.string.key_price), price)
        intent.putExtra(getString(R.string.key_type_category), category)
        startActivity(intent)
    }


}