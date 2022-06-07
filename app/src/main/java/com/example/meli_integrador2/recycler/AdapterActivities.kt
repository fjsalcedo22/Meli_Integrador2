package com.example.meli_integrador2.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meli_integrador2.R

class AdapterActivities(private val listActivities : Array<String>) : RecyclerView.Adapter<ActivitiesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_activitites_item, parent, false)
        return ActivitiesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        val activities = listActivities[position]
        holder.bind(activities)
    }

    override fun getItemCount() = listActivities.size
}