package com.example.growighassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class VideosActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videos)

        viewPager = findViewById(R.id.viewPager)
        val videoPagerAdapter = VideoPagerAdapter(getVideos())
        viewPager.adapter = videoPagerAdapter
    }

    private fun getVideos(): List<VideoData> {
        val link1 = "https://static.videezy.com/system/resources/previews/000/043/143/original/lights_go.mp4"
        val link2 = "https://static.videezy.com/system/resources/previews/000/005/357/original/23.mp4"
        val link3 = "https://static.videezy.com/system/resources/previews/000/019/708/original/winter2.mp4"

        val videoData1 = VideoData(link1, "Beautiful Lights Trails by Videezy")
        val videoData2 = VideoData(link2, "Water rapids in a creek by Videezy")
        val videoData3 = VideoData(link3, "Snow Christmas by Videezy")

        return listOf(videoData1, videoData2, videoData3)
    }
}