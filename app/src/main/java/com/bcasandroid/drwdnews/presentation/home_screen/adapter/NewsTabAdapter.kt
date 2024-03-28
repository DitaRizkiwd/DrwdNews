package com.bcasandroid.drwdnews.presentation.home_screen.adapter

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class NewsTabAdapter(fragment: Fragment):FragmentStateAdapter(fragment.childFragmentManager, fragment.lifecycle) {
    private val fragmentContent = arrayListOf<Fragment>()


    fun addListFragment(fragment: Fragment){
        fragmentContent.add(fragment)
    }
    override fun getItemCount()=fragmentContent.size

    override fun createFragment(position: Int): Fragment {
        return fragmentContent[position]
    }

}