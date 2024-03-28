package com.bcasandroid.drwdnews.presentation.home_screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bcasandroid.drwdnews.base.BaseFragment
import com.bcasandroid.drwdnews.databinding.FragmentHomeBinding
import com.bcasandroid.drwdnews.presentation.bussiness_screen.view.BussinessFragment
import com.bcasandroid.drwdnews.presentation.home_screen.adapter.NewsTabAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(){


    private var adapternews :NewsTabAdapter?=null
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater,container,false)
    }

    override fun setupView() {

        setUpTabView()
    }

    private fun setUpTabView(){
        val tabLayout = binding.tabtopbar
        val viewPager = binding.vptopbar

        adapternews = NewsTabAdapter(this)
        adapternews?.addListFragment(BussinessFragment())
        viewPager.adapter=adapternews
        TabLayoutMediator(tabLayout,viewPager){
            tab,position ->
                when(position){
                    0->{
                        tab.text = "Bussiness"
                    }
                }
        }.attach()
    }

}