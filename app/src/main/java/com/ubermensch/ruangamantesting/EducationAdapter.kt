package com.ubermensch.ruangamantesting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EducationAdapter(
    private val items: List<EducationArticle>,
    private val onItemClick: (EducationArticle) -> Unit
) : RecyclerView.Adapter<EducationAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView     = itemView.findViewById(R.id.tvItemTitle)
        val tvShortDesc: TextView = itemView.findViewById(R.id.tvItemShortDesc)
        val tvAuthor: TextView    = itemView.findViewById(R.id.tvItemAuthor)
        val tvDate: TextView      = itemView.findViewById(R.id.tvItemDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_education_detail, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = items[position]
        holder.tvTitle.text     = article.title
        holder.tvShortDesc.text = article.shortDesc
        holder.tvAuthor.text    = article.author
        holder.tvDate.text      = article.date
        holder.itemView.setOnClickListener { onItemClick(article) }
    }

    override fun getItemCount(): Int = items.size
}
