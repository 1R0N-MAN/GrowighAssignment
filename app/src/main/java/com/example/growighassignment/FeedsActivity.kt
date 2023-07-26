package com.example.growighassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class FeedsActivity : AppCompatActivity() {

    private lateinit var feedsContentRecyclerAdapter: FeedContentRecyclerAdapter
    private lateinit var feedsContentRecyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var uploadImageButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feeds)

        feedsContentRecyclerView = findViewById(R.id.feedsContentRecyclerView)

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)
        swipeRefreshLayout.setOnRefreshListener { fetchImages() }

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> {
                    true
                }
                R.id.action_videos -> {
                    val intent = Intent(this, VideosActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.action_map -> {
                    val intent = Intent(this, MapsActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        uploadImageButton = findViewById(R.id.uploadImageButton)
        uploadImageButton.setOnClickListener {
            val intent = Intent(this, UploadImageActivity::class.java)
            startActivity(intent)
        }

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