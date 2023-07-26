package com.example.growighassignment

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.like.LikeButton

class VideoPagerAdapter(private val videos: List<VideoData>) : RecyclerView.Adapter<VideoPagerAdapter.VideoViewHolder>() {

    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val videoPlayer: VideoView = itemView.findViewById(R.id.videoPlayer)
        private val likeButton: LikeButton = itemView.findViewById(R.id.videoLikeButton)
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)

        fun bind(videoData: VideoData){
            videoPlayer.setVideoPath(videoData.url)

            val mediaController = MediaController(itemView.context)
            mediaController.setAnchorView(videoPlayer)

            videoPlayer.setMediaController(mediaController)
            videoPlayer.setVideoURI(Uri.parse(videoData.url))
            videoPlayer.requestFocus()

            videoPlayer.setOnPreparedListener { mp ->
                mp.start()
            }

            likeButton.setOnClickListener {
                likeButton.isLiked = !likeButton.isLiked
            }

            titleTextView.text = videoData.title

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val videoData = videos[position]

        holder.bind(videoData)
    }

    override fun getItemCount(): Int = videos.size

}
