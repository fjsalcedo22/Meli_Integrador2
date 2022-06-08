package com.example.meli_integrador2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meli_integrador2.databinding.ActivityActivitiesBinding
import com.example.meli_integrador2.interfaces.OnItemClickListener
import com.example.meli_integrador2.recycler.AdapterActivities
import com.example.meli_integrador2.webService.Retrofit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Activities : AppCompatActivity(), OnItemClickListener {
    private lateinit var binding: ActivityActivitiesBinding
    private lateinit var adapter: AdapterActivities
    private lateinit var participants: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        participants = intent.getStringExtra(getString(R.string.key_number_participants)).toString()
        val list = resources.getStringArray(R.array.list_activities)
        adapter = AdapterActivities(list, this)
        binding.recyclerActivities.layoutManager = LinearLayoutManager(this)
        binding.recyclerActivities.adapter = adapter

        binding.imageButtonRandom.setOnClickListener {
            getActivityWebService()
        }

    }

    override fun onItemClick(category: String) {
        getActivityWebService(category)
    }

    private fun getActivityWebService(category: String? = null) {

        CoroutineScope(Dispatchers.IO).launch {
            val response = Retrofit.getRetrofit.run {
                category?.let { getActivity(it.lowercase(), participants) } ?: getActivityrandom(
                    participants
                )
            }
            println(response.code())
            if (response.isSuccessful)
                println(response.body())
            else
                println(response.errorBody())
        }
    }
}