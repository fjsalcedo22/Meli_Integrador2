package com.example.meli_integrador2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.meli_integrador2.databinding.ActivityActivitiesBinding
import com.example.meli_integrador2.recycler.AdapterActivities

class Activities : AppCompatActivity() {
    private lateinit var binding : ActivityActivitiesBinding
    private lateinit var adapter : AdapterActivities
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = resources.getStringArray(R.array.list_activities)
        adapter = AdapterActivities(list)
        binding.recyclerActivities.layoutManager = LinearLayoutManager(this)
        binding.recyclerActivities.adapter = adapter

    }
}