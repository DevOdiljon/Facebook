package com.example.facebook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.facebook.model.Story

class StoryAdapter(var context: Context, var items: ArrayList<Story>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var ITEM_TYPE_ONE = 0
    var ITEM_TYPE_OTHER = 1

    override fun getItemViewType(position: Int): Int {
        if (position == 0){
            return ITEM_TYPE_ONE
        }
        return ITEM_TYPE_OTHER
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ITEM_TYPE_ONE){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story_add, parent, false)
            return OneViewHolder(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story_other, parent, false)
        return OtherViewHolder(view)
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item = items[position]
        if (holder is OneViewHolder){

        }
        if (holder is OtherViewHolder){
            var profile = holder.profile
            var backround = holder.backround
            var fullname = holder.fullname

            profile.setImageResource(item.image!!)
            backround.setImageResource(item.background!!)
            fullname.text = item.fullname
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class OtherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var profile: ImageView
        var backround: ImageView
        var fullname: TextView

        init {
            profile = view.findViewById(R.id.iv_profile)
            backround = view.findViewById(R.id.iv_backround)
            fullname = view.findViewById(R.id.tv_fullname)
        }
    }

    class OneViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}