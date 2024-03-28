package com.bcasandroid.drwdnews.presentation.home_screen.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.bcasandroid.drwdnews.R
import com.bcasandroid.drwdnews.databinding.ActivityHomeBinding
import com.bcasandroid.drwdnews.presentation.bussiness_screen.view.BussinessFragment
import com.bcasandroid.drwdnews.utils.NewsItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), NewsItemClickListener {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }

    override fun onNewsItemClickListener(url: String) {
         val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}