package com.example.meli_integrador2.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.meli_integrador2.databinding.AdapterActivititesItemBinding

class ActivitiesViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private var binding = AdapterActivititesItemBinding.bind(view)

     fun bind(activities : String){
         binding.textViewActivities.text = activities
     }
}
