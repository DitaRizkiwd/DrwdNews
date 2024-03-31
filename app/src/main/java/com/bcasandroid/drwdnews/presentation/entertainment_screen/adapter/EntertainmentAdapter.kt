package com.bcasandroid.drwdnews.presentation.entertainment_screen.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bcasandroid.drwdnews.R
import com.bcasandroid.drwdnews.data.response_model.Article
import com.bcasandroid.drwdnews.databinding.ItemDescriptionNewsBinding
import com.bcasandroid.drwdnews.presentation.entertainment_screen.adapter.EntertainmentAdapter.*
import com.bcasandroid.drwdnews.utils.NewsItemClickListener
import com.bumptech.glide.Glide

class EntertainmentAdapter(private val entertainmentdata:List<Article>,
                            private val context :Context,
                            private val newsItemClickListener: NewsItemClickListener):
    RecyclerView.Adapter<EntertainmentAdapter.entertainmentViewHolder>(){

    inner class entertainmentViewHolder(val binding:ItemDescriptionNewsBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(data:Article){
            binding.tvdesctitlenews.text=data.title
            binding.tvdescnews.text=data.description

            Glide.with(context)
                .load(data.urlToImage)
                .centerCrop()
                .placeholder(R.drawable.logoberita) // Placeholder image while loading
                .error(R.drawable.ic_launcher_background) // Error image if loading fails
                .into(binding.ivdescnews)
            binding.root.setOnClickListener{
                newsItemClickListener.onNewsItemClickListener(data.url)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): entertainmentViewHolder {
        return entertainmentViewHolder(
            ItemDescriptionNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount()=entertainmentdata.size

    override fun onBindViewHolder(holder: entertainmentViewHolder, position: Int) {
        holder.bind(entertainmentdata[position])
    }
}