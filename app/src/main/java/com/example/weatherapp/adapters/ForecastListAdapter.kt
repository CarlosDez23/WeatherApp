package com.example.weatherapp.adapters

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.adapters.ForecastListAdapter.ViewHolder

class ForecastListAdapter(val items: List<String>) :
        RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]
    }

    class ViewHolder (val textView: TextView) :RecyclerView.ViewHolder(textView)

}