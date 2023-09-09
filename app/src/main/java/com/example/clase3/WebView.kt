package com.example.clase3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.clase3.databinding.ActivityMainBinding
import com.example.clase3.databinding.ActivityWebViewBinding

class WebView : AppCompatActivity() {
    lateinit var binding: ActivityWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_web_view)
        webView()
    }

    private fun webView(){

        val urlWeb = "https://play.google.com/store/games"
        binding.wvEjemplo.apply {
            settings.apply {
                javaScriptEnabled = true
            }
            loadUrl(urlWeb)
        }


    }
}