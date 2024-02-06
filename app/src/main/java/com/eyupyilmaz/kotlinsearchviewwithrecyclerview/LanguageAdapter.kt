package com.eyupyilmaz.kotlinsearchviewwithrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class LanguageAdapter(var languageList: List<LanguageItem>) :
    RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {


    var onItemClick :((LanguageItem) -> Unit)? = null

    inner class LanguageViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val logo : ImageView = itemView.findViewById(R.id.logoIV)
        val title : TextView = itemView.findViewById(R.id.titleTV)
    }

    fun setFilteredList(languageList : List<LanguageItem>)
    {
        this.languageList = languageList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false)
        return LanguageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return languageList.size
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.title.text = languageList[position].title
        Glide.with(holder.itemView).load(languageList[position].logo).into(holder.logo)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(languageList[position])
        }
    }
}