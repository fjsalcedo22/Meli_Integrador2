package com.example.meli_integrador2.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.meli_integrador2.databinding.AdapterActivitiesItemBinding

/**
  View holder class to display the list visually
 */
class ActivitiesViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private var binding = AdapterActivitiesItemBinding.bind(view)

     fun bind(activities : String){
         binding.textViewActivities.text = activities
     }
}
