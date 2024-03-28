package com.bcasandroid.drwdnews.presentation.bussiness_screen.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bcasandroid.drwdnews.R
import com.bcasandroid.drwdnews.data.response_model.Article
import com.bcasandroid.drwdnews.data.response_model.NewsResponse
import com.bcasandroid.drwdnews.databinding.ItemDescriptionNewsBinding
import com.bumptech.glide.Glide

class BussinessAdapter(private val bussinessdata: List<Article>, private val context: Context) :
    RecyclerView.Adapter<BussinessAdapter.bussinessViewHolder>() {

    inner class bussinessViewHolder(val binding: ItemDescriptionNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Article) {
            binding.tvdesctitlenews.text = data.title
            binding.tvdescnews.text = data.description

            Glide.with(context)
                .load(data.urlToImage)
                .centerCrop()
                .placeholder(R.drawable.logoberita) // Placeholder image while loading
                .error(R.drawable.ic_launcher_background) // Error image if loading fails
                .into(binding.ivdescnews)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bussinessViewHolder {
        return bussinessViewHolder(
            ItemDescriptionNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount()=bussinessdata.size
    override fun onBindViewHolder(holder: bussinessViewHolder, position: Int) {
        holder.bind(bussinessdata[position])
    }
}