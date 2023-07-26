package com.example.growighassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.like.LikeButton

class FeedContentRecyclerAdapter(
    private val feedContentItems: List<FeedContent>,
    private val context: Context
) : RecyclerView.Adapter<FeedContentRecyclerAdapter.FeedContentViewHolder>() {

    class FeedContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val feedContentImage: ImageView = itemView.findViewById(R.id.feedContentImage)
        val likeButton: LikeButton = itemView.findViewById(R.id.likeButton)
        val noOfLikesTextView: TextView = itemView.findViewById(R.id.noOfLikesTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedContentViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.feeds_content_item_layout, parent, false)
        return FeedContentViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedContentViewHolder, position: Int) {
        val feedContent = feedContentItems[position]
        Glide.with(context)
            .load(feedContent.imageUrl)
            .apply(RequestOptions()
                .placeholder(R.drawable.background)
                .error(R.drawable.dummy_image)
            )
            .centerCrop()
            .into(holder.feedContentImage)

        holder.likeButton.setOnClickListener {
            val noOfLikes = holder.noOfLikesTextView.text.split(" ")[0].toInt()

            val isLiked = holder.likeButton.isLiked
            var newLikesCount = ""

            if (isLiked) {
                holder.likeButton.isLiked = false
                newLikesCount = "${noOfLikes - 1} likes"
            } else {
                holder.likeButton.isLiked = true
                newLikesCount = "${noOfLikes + 1} likes"
            }

            holder.noOfLikesTextView.text = newLikesCount
        }
    }

    override fun getItemCount(): Int {
        return feedContentItems.size
    }
}