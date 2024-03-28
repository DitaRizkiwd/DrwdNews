package com.bcasandroid.drwdnews.presentation.home_screen.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bcasandroid.drwdnews.data.remote.NewsRemoteDataSource
import com.bcasandroid.drwdnews.data.response_model.NewsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val newsRemoteDataSource: NewsRemoteDataSource)
    : ViewModel() {
    private val _homeNews = MutableLiveData<NewsResponse>()
    private val _homeNewsError = MutableLiveData<String>()

    val homeNews: LiveData<NewsResponse>
        get() = _homeNews

    val homeNewsError: LiveData<String>
        get() = _homeNewsError


    fun getHomeNews() = viewModelScope.launch(Dispatchers.IO) {
        newsRemoteDataSource.getDataNews().let {
            if(it.isSuccessful){
                _homeNews.postValue(it.body())
            }
            else{
                _homeNewsError.postValue(it.message())
            }

        }
    }
}


