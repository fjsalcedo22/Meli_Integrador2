package com.example.meli_integrador2.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meli_integrador2.R
import com.example.meli_integrador2.interfaces.OnItemClickListener

class AdapterActivities(private val listActivities : Array<String>, val listener : OnItemClickListener) : RecyclerView.Adapter<ActivitiesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_activitites_item, parent, false)
        val holder = ActivitiesViewHolder(view)

        view.rootView.setOnClickListener {
            listener.onItemClick(listActivities.get(holder.adapterPosition))
        }
        return holder
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        val activities = listActivities[position]
        holder.bind(activities)
    }

    override fun getItemCount() = listActivities.size
}