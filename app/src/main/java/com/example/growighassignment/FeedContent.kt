package com.example.growighassignment

data class FeedContent(val id: Int){
    val imageUrl: String = "https://picsum.photos/300/200?random=$id"
}
