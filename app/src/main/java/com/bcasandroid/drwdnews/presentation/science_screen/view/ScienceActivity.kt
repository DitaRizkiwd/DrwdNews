package com.bcasandroid.drwdnews.presentation.science_screen.view

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bcasandroid.drwdnews.R
import com.bcasandroid.drwdnews.databinding.ActivityScienceBinding

class ScienceActivity :AppCompatActivity(){
    private lateinit var binding: ActivityScienceBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScienceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("url")
        webViewSetup(url)
        binding.backscience .setOnClickListener{
            if(binding.wvscience.canGoBack()){
                binding.wvscience .goBack()
            }else{
                finish()
            }
        }

    }
    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup(baseurl:String?)
    {
        binding.wvscience.webViewClient= WebViewClient()
        val loading = binding.progressscience
        binding.wvscience.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                loading.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                loading.visibility = View.GONE
            }
        }

        binding.wvscience.apply {
            settings.javaScriptEnabled=true
            settings.safeBrowsingEnabled=true
        }
        baseurl?.let{
            binding.wvscience.loadUrl(it)
        }

    }


}