package com.bcasandroid.drwdnews.presentation.splash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bcasandroid.drwdnews.R
import com.bcasandroid.drwdnews.databinding.ActivityGetStartedBinding
import com.bcasandroid.drwdnews.presentation.home_screen.view.HomeActivity

class GetStartedActivity : AppCompatActivity() {
    private lateinit var binding : ActivityGetStartedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvgetstarted.setOnClickListener{
            intenTo(HomeActivity::class.java)
    }


    }
    private fun intenTo(clazz:Class<*>){
        val intent = Intent(this,clazz)
        startActivity(intent)
    }

}
