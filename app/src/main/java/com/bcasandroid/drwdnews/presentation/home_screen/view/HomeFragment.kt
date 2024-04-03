package com.bcasandroid.drwdnews.presentation.home_screen.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.bcasandroid.drwdnews.base.BaseFragment
import com.bcasandroid.drwdnews.databinding.FragmentHomeBinding
import com.bcasandroid.drwdnews.presentation.bussiness_screen.view.BussinessFragment
import com.bcasandroid.drwdnews.presentation.entertainment_screen.view.EntertainmentFragment
import com.bcasandroid.drwdnews.presentation.home_screen.adapter.NewsTabAdapter
import com.bcasandroid.drwdnews.presentation.science_screen.view.ScienceFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {


    private var adapternews: NewsTabAdapter? = null
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        binding.progressbar.visibility = View.VISIBLE
        setUpTabView()
        binding.progressbar.visibility= View.GONE

    }

    private fun setUpTabView() {
        val tabLayout = binding.tabtopbar
        val viewPager = binding.vptopbar
        val loading = binding.progressbar

        adapternews = NewsTabAdapter(this)
        adapternews?.addListFragment(BussinessFragment())
        adapternews?.addListFragment(EntertainmentFragment())
        adapternews?.addListFragment(ScienceFragment())
        viewPager.adapter = adapternews
        TabLayoutMediator(tabLayout, viewPager) {

                tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Bussiness"

                }

                1 -> {
                    tab.text = "Entertainment"
                }

                2 -> {
                    tab.text = "Science"
                }


            }

        }.attach()
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                if (state == ViewPager2.SCROLL_STATE_DRAGGING || state == ViewPager2.SCROLL_STATE_SETTLING) {
                    // Ketika sedang melakukan scroll atau menetapkan halaman
                    loading.visibility = View.VISIBLE
                } else if (state == ViewPager2.SCROLL_STATE_IDLE) {
                    // Ketika proses loading sudah selesai
                    loading.visibility = View.GONE
                }
            }
        })

    }


}