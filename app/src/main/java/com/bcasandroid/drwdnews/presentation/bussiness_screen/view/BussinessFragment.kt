package com.bcasandroid.drwdnews.presentation.bussiness_screen.view

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.bcasandroid.drwdnews.base.BaseFragment
import com.bcasandroid.drwdnews.data.response_model.Article
import com.bcasandroid.drwdnews.databinding.FragmentBussinessBinding
import com.bcasandroid.drwdnews.presentation.bussiness_screen.adapter.BussinessAdapter
import com.bcasandroid.drwdnews.presentation.bussiness_screen.view_model.BussninessViewModel
import com.bcasandroid.drwdnews.utils.NewsItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BussinessFragment : BaseFragment<FragmentBussinessBinding>(){
    private lateinit var bussinessNewsAdapter: BussinessAdapter
    private val viewmodel: BussninessViewModel by viewModels()
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBussinessBinding {
        return FragmentBussinessBinding.inflate(inflater, container, false)
    }


    override fun setupView() {
        viewmodel.getBussinessNews()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewmodel.homeBussinessNews.observe(viewLifecycleOwner){
            setUpViewBussiness(it.articles)
        }
    }

    private fun setUpViewBussiness(data: List<Article>?) {
        bussinessNewsAdapter = BussinessAdapter(
            bussinessdata = data ?: listOf(),
            context = binding.root.context
        )
        binding.componenbussiness.rvNewsComponen.adapter = bussinessNewsAdapter
        binding.componenbussiness.rvNewsComponen.setOnClickListener { trans->  }

    }



}