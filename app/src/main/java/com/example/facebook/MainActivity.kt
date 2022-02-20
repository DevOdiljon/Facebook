package com.example.facebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facebook.model.Feed
import com.example.facebook.model.Post
import com.example.facebook.model.Profile
import com.example.facebook.model.Story

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }
    fun initViews(){
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        refreshFeedAdapter(getAllFeed())
    }

    private fun refreshFeedAdapter(items: ArrayList<Feed>) {
        var adapter = FeedAdapter(this, items)
        recyclerView.adapter = adapter
    }

    private fun getAllFeed(): ArrayList<Feed> {

        var stories = ArrayList<Story>()
        stories.add(Story())
        stories.add(Story(R.drawable.im_user_2, "Kucharov Alijon", R.drawable.im_post_1))
        stories.add(Story(R.drawable.im_user_3, "Shukurov Sirojiddin", R.drawable.im_post_2))
        stories.add(Story(R.drawable.im_user_2, "Murotaliyev Davron", R.drawable.im_post_3))
        stories.add(Story(R.drawable.im_user_1, "Kucharov Alijon", R.drawable.im_post_1))
        stories.add(Story(R.drawable.im_user_2, "Shukurov Sirojiddin", R.drawable.im_post_2))
        stories.add(Story(R.drawable.im_user_3, "Murotaliyev Davron", R.drawable.im_post_3))


        var feeds = ArrayList<Feed>()

        feeds.add(Feed(1))
        feeds.add(Feed(stories, 2))
        feeds.add(Feed(Post(R.drawable.im_user_1, "Murotaliyev Davron", R.drawable.im_post_1), 3))
        feeds.add(Feed(5, Profile(R.drawable.im_user_1)))
        feeds.add(Feed(Post(R.drawable.im_user_2, "Shukurov Sirojiddin", R.drawable.im_post_2), 3))
        feeds.add(Feed(4))
        feeds.add(Feed(Post(R.drawable.im_user_3, "Murotaliyev Davron", R.drawable.im_post_3), 3))
        feeds.add(Feed(Post(R.drawable.im_user_1, "Kucharov Alijon", R.drawable.im_post_1), 3))
        feeds.add(Feed(4))
        feeds.add(Feed(Post(R.drawable.im_user_2, "Shukurov Sirojiddink", R.drawable.im_post_2), 3))
        feeds.add(Feed(Post(R.drawable.im_user_3, "Odilbek", R.drawable.im_post_3), 3))
        feeds.add(Feed(5, Profile(R.drawable.im_user_1)))
        feeds.add(Feed(Post(R.drawable.im_user_1, "Kucharov Alijon", R.drawable.im_post_1), 3))
        feeds.add(Feed(Post(R.drawable.im_user_2, "Murotaliyev Davron", R.drawable.im_post_2), 3))
        feeds.add(Feed(4))
        feeds.add(Feed(Post(R.drawable.im_user_3, "Shukurov Sirojiddin", R.drawable.im_post_3), 3))


        return feeds
    }
}