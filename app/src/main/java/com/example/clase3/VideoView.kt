package com.example.clase3

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import androidx.databinding.DataBindingUtil
import com.example.clase3.databinding.ActivityMainBinding
import com.example.clase3.databinding.ActivityVideoViewBinding

class VideoView : AppCompatActivity() {
    lateinit var binding: ActivityVideoViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_video_view)
        videoView()
    }

    private fun videoView(){
        var videoView = binding.vvEjemplo
        var enlaceVideo = "android.resource://${packageName}/${R.raw.video}"
        videoView.setVideoURI(Uri.parse(enlaceVideo))

        var mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
    }
}