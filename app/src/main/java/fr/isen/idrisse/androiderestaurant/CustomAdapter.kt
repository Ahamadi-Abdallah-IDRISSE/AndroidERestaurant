package fr.isen.idrisse.androiderestaurant

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.idrisse.androiderestaurant.databinding.CellCustomBinding
import fr.isen.idrisse.androiderestaurant.network.Plate

class CustomAdapter(val items: List<Plate>, val clickListener: (Plate) -> Unit): RecyclerView.Adapter<CustomAdapter.CellViewHolder>() {
    class CellViewHolder(binding: CellCustomBinding) : RecyclerView.ViewHolder(binding.root) {
        val textView: TextView = binding.textView
        val imageView = binding.imageView
        val priceTextView = binding.priceTextView
        val root = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CellViewHolder {
        val binding = CellCustomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CellViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: CellViewHolder, position: Int) {
        val plate = items[position]
        holder.textView.text = plate.name
        holder.priceTextView.text = plate.prices.first().price + " €"
        Picasso.get().load(getThumbnail(plate)).into(holder.imageView)
        holder.root.setOnClickListener {
            Log.d("click", "click on ${position}")
            clickListener(plate)
        }
    }

    private fun getThumbnail(plate: Plate): String? {
        return if (plate.images.isNotEmpty() && plate.images.firstOrNull()?.isNotEmpty() == true) {
            plate.images.firstOrNull()
        } else {
            null
        }
    }
}