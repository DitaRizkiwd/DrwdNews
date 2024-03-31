package com.bcasandroid.drwdnews.presentation.entertainment_screen.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bcasandroid.drwdnews.base.BaseFragment
import com.bcasandroid.drwdnews.data.response_model.Article
import com.bcasandroid.drwdnews.databinding.FragmentEntertainmentBinding
import com.bcasandroid.drwdnews.presentation.bussiness_screen.view.BussinessActivity
import com.bcasandroid.drwdnews.presentation.entertainment_screen.adapter.EntertainmentAdapter
import com.bcasandroid.drwdnews.presentation.entertainment_screen.view_model.EntertainmentViewModel
import com.bcasandroid.drwdnews.utils.NewsItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EntertainmentFragment : BaseFragment<FragmentEntertainmentBinding>(),NewsItemClickListener{
    private lateinit var entertainmentAdapter: EntertainmentAdapter
    private val viewmodel: EntertainmentViewModel by viewModels()
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEntertainmentBinding {
        return FragmentEntertainmentBinding.inflate(inflater,container,false)
    }

    override fun setupView() {
        viewmodel.getEntertainmnetNews()
        observeViewModelen()
    }
    private fun observeViewModelen(){
        viewmodel.homeEntertainmentNews.observe(viewLifecycleOwner){
            setUpViewEntertainment(it.articles)
        }
    }
    private fun setUpViewEntertainment(data: List<Article>?){
        entertainmentAdapter = EntertainmentAdapter(
            entertainmentdata = data?: listOf(),
            context = binding.root.context,
            newsItemClickListener = this
        )
        binding.componenentertainmnet.rvNewsComponen.adapter= entertainmentAdapter
    }

    override fun onNewsItemClickListener(url: String) {
        val intent = Intent(requireContext(), EntertainmentActivity::class.java)
        intent.putExtra("url",url)
        startActivity(intent)
    }

}