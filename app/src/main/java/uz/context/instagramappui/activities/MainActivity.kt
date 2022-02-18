package uz.context.instagramappui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.context.instagramappui.R
import uz.context.instagramappui.adapter.FeedAdapter
import uz.context.instagramappui.model.Feed
import uz.context.instagramappui.model.Post
import uz.context.instagramappui.model.Story

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private val feeds: ArrayList<Feed> = ArrayList()
    private val stories: ArrayList<Story> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }
    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this,1)

        refreshAdapter(getAllFeeds())
    }

    private fun refreshAdapter(feeds: ArrayList<Feed>) {
        val adapter = FeedAdapter(this, feeds)
        recyclerView.adapter = adapter
    }
    private fun getAllFeeds(): ArrayList<Feed> {

        stories.add(Story(R.drawable.ggole,"Google"))
        stories.add(Story(R.drawable.tg,"Telegram"))
        stories.add(Story(R.drawable.im_instagram,"Instagram"))
        stories.add(Story(R.drawable.tiktoklogo,"Tik Tok"))
        stories.add(Story(R.drawable.twitter,"Twitter"))
        stories.add(Story(R.drawable.yumaloqface,"Facebook"))
        stories.add(Story(R.drawable.pin,"Pinterest"))

        feeds.add(Feed(stories))
        feeds.add(Feed(Post(R.drawable.ggole,"Google",R.drawable.ggole)))
        feeds.add(Feed(Post(R.drawable.tg,"Telegram",R.drawable.tg)))
        feeds.add(Feed(Post(R.drawable.im_instagram,"Instagram",R.drawable.im_instagram)))
        feeds.add(Feed(Post(R.drawable.tiktoklogo,"Tik Tok",R.drawable.tiktoklogo)))
        feeds.add(Feed(Post(R.drawable.twitter,"Twitter",R.drawable.twitter)))
        feeds.add(Feed(Post(R.drawable.yumaloqface,"Facebook",R.drawable.yumaloqface)))
        feeds.add(Feed(Post(R.drawable.pin,"Pinterest",R.drawable.pin)))

        return feeds
    }
}