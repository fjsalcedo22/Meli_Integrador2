package com.example.meli_integrador2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meli_integrador2.R
import com.example.meli_integrador2.databinding.ActivityActivitiesBinding
import com.example.meli_integrador2.interfaces.OnItemClickListener
import com.example.meli_integrador2.recycler.AdapterActivities


/**
- ScreenActivities
 */
class Activities : AppCompatActivity(), OnItemClickListener {
    private lateinit var binding: ActivityActivitiesBinding
    private lateinit var adapter: AdapterActivities
    private lateinit var participants: String
    private lateinit var price: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // make the filling of the adapter of the static view to show it in the recycler
        val list = resources.getStringArray(R.array.list_activities)
        adapter = AdapterActivities(list, this)
        binding.recyclerActivities.layoutManager = LinearLayoutManager(this)
        binding.recyclerActivities.adapter = adapter

        // listener that listens when pressed ImageButton Random
        binding.imageButtonRandom.setOnClickListener {
            intentToScreenTips()
        }

    }

    override fun onResume() {
        super.onResume()

        // Get the information sent by the previous activity
        participants = intent.getStringExtra(getString(R.string.key_number_participants)).toString()
        price = intent.getStringExtra(getString(R.string.key_price)).toString()
    }

    override fun onItemClick(category: String) { // implemented function of the interface which will obtain the position that was chosen in the adapter
        intentToScreenTips(category)
    }

    private fun intentToScreenTips(category: String? = null) { // // function for navigate to the activity (ScreenTips) and send the collected information
        val intent = Intent(this, ScreenTips::class.java)
        intent.putExtra(getString(R.string.key_number_participants), participants)
        intent.putExtra(getString(R.string.key_price), price)
        intent.putExtra(getString(R.string.key_type_category), category)
        startActivity(intent)
    }


}