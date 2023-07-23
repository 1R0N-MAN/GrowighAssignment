package com.example.growighassignment

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import java.io.IOException

class UploadImageActivity : AppCompatActivity() {

    private lateinit var btnRemoveImage: ImageView
    private lateinit var btnSelectImage: Button
    private lateinit var uploadedImageContainer: ImageView
    private lateinit var goBackButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_image)

        uploadedImageContainer = findViewById(R.id.uploadedImageContainer)

        btnRemoveImage = findViewById(R.id.btnRemoveImage)
        btnRemoveImage.setOnClickListener {
            uploadedImageContainer.setImageResource(R.drawable.upload_image)
        }

        btnSelectImage = findViewById(R.id.btnSelectImage)
        btnSelectImage.setOnClickListener { selectImageFromGallery() }

        goBackButton = findViewById(R.id.goBackButton)
        goBackButton.setOnClickListener { finish() }
    }

    private fun selectImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        selectImageLauncher.launch(intent)
    }

    private val selectImageLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val selectedImage = data?.data
            // Process the selected image
            selectedImage?.let {
                val bitmap: Bitmap? = loadBitmapFromUri(it)
                bitmap?.let {
                    uploadedImageContainer.setImageBitmap(bitmap)
                }
            }
        }
    }

    private fun loadBitmapFromUri(uri: Uri): Bitmap? {
        return try {
            val inputStream = contentResolver.openInputStream(uri)
            BitmapFactory.decodeStream(inputStream)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}