package com.bcasandroid.drwdnews.presentation.bussiness_screen.view

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import com.bcasandroid.drwdnews.R
import com.bcasandroid.drwdnews.data.response_model.Article
import com.bcasandroid.drwdnews.data.response_model.NewsResponse
import com.bcasandroid.drwdnews.databinding.ActivityBussinessBinding
import com.bcasandroid.drwdnews.utils.NewsItemClickListener

class BussinessActivity : AppCompatActivity(){
    private lateinit var binding :ActivityBussinessBinding
    private lateinit var progressBar: ProgressBar


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBussinessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("url")
        webViewSetup(url)

        binding.backbussiness.setOnClickListener{
            if(binding.wvbussiness.canGoBack()){
                binding.wvbussiness.goBack()
            }else{
                finish()
            }
        }
    }
    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup(baseurl:String?){
        binding.wvbussiness.webViewClient= WebViewClient()
        progressBar=findViewById(R.id.pbbussiness)
        binding.wvbussiness.apply {
            settings.javaScriptEnabled=true
            settings.safeBrowsingEnabled=true
        }
        baseurl?.let{
            binding.wvbussiness.loadUrl(it)
        }
    }


//    override fun onNewsItemClickListener(url: String) {
//        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//        startActivity(intent)
//    }

}