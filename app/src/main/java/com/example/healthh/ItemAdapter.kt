package com.example.healthh

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.healthhome.DB.ModelData

class ItemAdapter (
    private val context: Context,
    private val healthInfo: List<ModelData>,
    val listener: (ModelData) -> Unit
        ) : RecyclerView.Adapter<ItemAdapter.HealthViewModel>()
{
    class HealthViewModel(view: View) : RecyclerView.ViewHolder(view){
        val titleTv = view.findViewById<TextView>(R.id.titleTv)
        val descTv = view.findViewById<TextView>(R.id.descTv)
        val deleteBtn = view.findViewById<ImageButton>(R.id.deleteBtn)

        fun bindView(health: ModelData, listener: (ModelData) -> Unit){
            titleTv.text = health.getTitle()
            descTv.text = health.getDesc()
            deleteBtn.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthViewModel =
        HealthViewModel(LayoutInflater.from(context).inflate(R.layout.list, parent, false))

    override fun getItemCount(): Int = healthInfo.size

    override fun onBindViewHolder(holder: HealthViewModel, position: Int) {
        holder.bindView(healthInfo[position], listener)
    }
}