package com.example.networkvsmvvmvscoroutineversion2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    private var list : List<ItemModel> = emptyList()
    private lateinit var context : Context

    fun setNewData(list: List<ItemModel>){
        this.list = list
        notifyDataSetChanged()
    }

    fun setContext(context: Context){
        this.context = context
    }


    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var imvImage : ImageView = itemView.findViewById(R.id.imv_image)
        var tvText : TextView = itemView.findViewById(R.id.tv_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_item,parent,false))
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        var itemModel = list.get(position)
        Glide.with(context).load(itemModel.owner.avatar_url).centerCrop().placeholder(R.drawable.ic_launcher_background).into(holder.imvImage)
        holder.tvText.text = itemModel.description
    }

    override fun getItemCount(): Int {
        return list.size
    }
}