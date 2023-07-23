package com.example.growighassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import java.util.*

class FeedsActivity : AppCompatActivity() {

    private lateinit var feedsContentRecyclerAdapter: FeedContentRecyclerAdapter
    private lateinit var feedsContentRecyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feeds)

        feedsContentRecyclerView = findViewById(R.id.feedsContentRecyclerView)

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)
        swipeRefreshLayout.setOnRefreshListener { fetchImages() }

        fetchImages()
    }

    private fun fetchImages() {
        val random = Random()
        val feedContent = List(10) { FeedContent(random.nextInt()) }
        feedsContentRecyclerAdapter = FeedContentRecyclerAdapter(feedContent, this)
        feedsContentRecyclerView.adapter = feedsContentRecyclerAdapter
        swipeRefreshLayout.isRefreshing = false
    }
}