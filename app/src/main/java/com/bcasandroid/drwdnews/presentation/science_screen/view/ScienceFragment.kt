package com.bcasandroid.drwdnews.presentation.science_screen.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bcasandroid.drwdnews.base.BaseFragment
import com.bcasandroid.drwdnews.data.response_model.Article
import com.bcasandroid.drwdnews.databinding.FragmentScienceBinding
import com.bcasandroid.drwdnews.presentation.science_screen.adapter.ScienceAdapter
import com.bcasandroid.drwdnews.presentation.science_screen.view_model.ScienceViewModel
import com.bcasandroid.drwdnews.utils.NewsItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScienceFragment :BaseFragment<FragmentScienceBinding>(), NewsItemClickListener{
    private lateinit var scienceNewsAdapter:ScienceAdapter
    private val viewmodel : ScienceViewModel by viewModels()


    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentScienceBinding {
        return FragmentScienceBinding.inflate(inflater,container,false)
    }

    override fun setupView() {
        viewmodel.getScienceNews()
        observeViewModel()
    }

    private fun observeViewModel(){
        viewmodel.homeScienceNews.observe(viewLifecycleOwner){
            setUpViewScience(it.articles)
        }
    }
    private fun setUpViewScience(data:List<Article>?){

        scienceNewsAdapter = ScienceAdapter(
            sciencedata = data ?: listOf(),
            context = binding.root.context,
            newsItemClickListener = this
        )
        binding.componenscience.rvNewsComponen.adapter=scienceNewsAdapter
    }

    override fun onNewsItemClickListener(url: String) {
        val intent = Intent(requireContext(), ScienceActivity::class.java)
        intent.putExtra("url",url)
        startActivity(intent)
    }

}