package fr.isen.idrisse.androiderestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.isen.idrisse.androiderestaurant.databinding.CellCustomBinding

class CustomAdapter(listOf: List<String>) : RecyclerView.Adapter<CustomAdapter.CellViewHolder>() {
    class CellViewHolder (binding: CellCustomBinding) : RecyclerView.ViewHolder(binding.root) {
        val textView:TextView = binding.textView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CellViewHolder {
        val binding = CellCustomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CellViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: CellViewHolder, position: Int) {
        holder.textView.text = "item "+position
    }
}