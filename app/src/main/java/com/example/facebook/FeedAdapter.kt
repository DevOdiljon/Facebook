package com.example.facebook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facebook.model.Feed
import com.example.facebook.model.Story

class FeedAdapter(var context: Context, var items: ArrayList<Feed>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var ITEM_VIEW_HEADER = 0
    var ITEM_VIEW_STORY = 1
    var ITEM_VIEW_POST = 2
    var ITEM_VIEW_ADVER = 3
    var ITEM_VIEW_PROFILE = 4

    override fun getItemViewType(position: Int): Int {
        var item = items[position]
        if (isHeader(position)) return ITEM_VIEW_HEADER
        if (isStory(position)) return ITEM_VIEW_STORY

        if (item.isHeader == 3) return ITEM_VIEW_POST

        if (item.isHeader == 4) return ITEM_VIEW_ADVER

        return ITEM_VIEW_PROFILE
    }

    private fun isStory(position: Int): Boolean {
        return position == 1
    }

    private fun isHeader(position: Int): Boolean {
        return position == 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ITEM_VIEW_HEADER){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_header_view, parent, false)
            return HeaderViewHolder(view)
        }
        if (viewType == ITEM_VIEW_STORY){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story, parent, false)
            return StoryViewHolder(view)
        }
        if (viewType == ITEM_VIEW_ADVER){
           val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post_advertising, parent, false)
            return AdverViewHolder(view)
        }
        if (viewType == ITEM_VIEW_PROFILE){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post_profile, parent, false)
            return ProfileViewHolder(view)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post_view, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item = items[position]
        if (holder is HeaderViewHolder){

        }
        if (holder is StoryViewHolder){
            var recyclerView = holder.recyclerView
            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            refreshAdapter(recyclerView, item.stories)
        }
        if (holder is PostViewHolder){
            var iv_profile = holder.profile
            var iv_photo = holder.post
            var tv_fullname = holder.fullname

            iv_profile.setImageResource(item.post!!.profile)
            tv_fullname.text = item.post!!.fullanme
            iv_photo.setImageResource(item.post!!.iv_post)
        }
        if (holder is AdverViewHolder){

        }
        if (holder is ProfileViewHolder){
            var profile  =holder.profile

            profile.setImageResource(item.profile!!.profile)
        }
    }

    private fun refreshAdapter(recyclerView: RecyclerView, stories: ArrayList<Story>) {
        var adapter = StoryAdapter(context, stories)
        recyclerView.adapter = adapter
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var profile: ImageView
        var fullname: TextView
        var post: ImageView

        init {
            profile = view.findViewById(R.id.iv_profile_post)
            fullname = view.findViewById(R.id.tv_fullname)
            post = view.findViewById(R.id.iv_post)
        }
    }

    class AdverViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var recyclerView: RecyclerView
        init {
            recyclerView = view.findViewById(R.id.recyclerView)
        }
    }

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
    class ProfileViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var profile: ImageView
        init {
            profile = view.findViewById(R.id.iv_post)
        }
    }
}