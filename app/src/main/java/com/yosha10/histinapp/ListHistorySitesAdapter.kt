package com.yosha10.histinapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yosha10.histinapp.databinding.ItemHistoryBinding

class ListHistorySitesAdapter(private val listHistorySites: ArrayList<HistorySites>): RecyclerView.Adapter<ListHistorySitesAdapter.ListViewHolder>() {

    companion object {
        const val KEY_HISTORY_SITES = "key_history_sites"
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListHistorySitesAdapter.ListViewHolder {
        val binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    class ListViewHolder(var binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ListHistorySitesAdapter.ListViewHolder, position: Int) {
        val (name, description, photo) = listHistorySites[position]
        holder.binding.tvName.text = name
        holder.binding.tvDescription.text = description
        holder.binding.imagePhoto.setImageResource(photo)
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra(KEY_HISTORY_SITES, listHistorySites[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listHistorySites.size
}