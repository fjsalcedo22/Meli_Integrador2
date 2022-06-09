package com.example.meli_integrador2.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meli_integrador2.R
import com.example.meli_integrador2.interfaces.OnItemClickListener

/**
  Adapter for static list of activities that receives two parameters : the list and an interface that works as a listener where the chosen position is sent in the recycler
 */
class AdapterActivities(private val listActivities : Array<String>,private val listener : OnItemClickListener) : RecyclerView.Adapter<ActivitiesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder { // Inflate the layout model (adapter_activities_item)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_activities_item, parent, false)
        val holder = ActivitiesViewHolder(view)

        view.rootView.setOnClickListener {  // listener to get the one click of each adapter item and send the result to the interface (OnItemClickListener)
            listener.onItemClick(listActivities[holder.adapterPosition])
        }
        return holder
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) { // List filling
        val activities = listActivities[position]
        holder.bind(activities)
    }

    override fun getItemCount() = listActivities.size // return size list
}