package com.example.recyclerwithglide

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerwithglide.MyAdapter.*
import kotlinx.android.synthetic.main.listitem.view.*

class MyAdapter(private var list: List<Photo>) : RecyclerView.Adapter<MyViewHolder>() {
    inner class MyViewHolder(parent:ViewGroup) : RecyclerView.ViewHolder(LayoutInflater
        .from(parent.context).inflate(R.layout.listitem, parent, false)){
        fun bind(myPhoto: Photo) = with(itemView){
           textView.text = myPhoto.description
           Glide.with(imageView.context).load(myPhoto.urls.full).centerCrop().into(imageView)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(parent)

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setPhotos(list: List<Photo>) {
        this.list = list
        notifyDataSetChanged()

    }
}