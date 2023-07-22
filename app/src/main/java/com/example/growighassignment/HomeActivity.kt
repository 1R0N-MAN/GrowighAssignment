package com.example.growighassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnFeeds = findViewById<Button>(R.id.btnFeeds)
        btnFeeds.setOnClickListener { openFeedsPage() }

        val btnUploadImage = findViewById<Button>(R.id.btnUploadImage)
        btnUploadImage.setOnClickListener { openUploadImagePage() }
    }

    private fun openFeedsPage() {
        startActivity(Intent(this, FeedsActivity::class.java))
    }

    private fun openUploadImagePage() {
        startActivity(Intent(this, UploadImageActivity::class.java))
    }
}