package com.bcasandroid.drwdnews.presentation.entertainment_screen.view

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bcasandroid.drwdnews.R
import com.bcasandroid.drwdnews.databinding.ActivityEntertainmentBinding
import com.bcasandroid.drwdnews.databinding.FragmentEntertainmentBinding


class EntertainmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEntertainmentBinding


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityEntertainmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("url")

        webViewSetup(url)

        binding.backentertainment.setOnClickListener{
            if(binding.wventertainment.canGoBack()){
                binding.wventertainment.goBack()
            }else{
                finish()
            }
        }
    }
    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup(baseurl:String?){
        binding.wventertainment.webViewClient= WebViewClient()
        binding.wventertainment.apply {
            settings.javaScriptEnabled=true
            settings.safeBrowsingEnabled=true
        }
        baseurl?.let{
            binding.wventertainment.loadUrl(it)
        }
    }
}