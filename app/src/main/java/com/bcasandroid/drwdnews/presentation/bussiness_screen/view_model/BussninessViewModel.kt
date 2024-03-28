package com.bcasandroid.drwdnews.presentation.bussiness_screen.view_model

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
class BussninessViewModel @Inject constructor(private val newsRemoteDataSource: NewsRemoteDataSource) :ViewModel() {
    private val _homeNewsBussiness = MutableLiveData<NewsResponse>()
    private val _homeNewsBussinessError = MutableLiveData<String>()

    val homeBussinessNews: LiveData<NewsResponse>
        get() = _homeNewsBussiness

    val homeNewsError: LiveData<String>
        get() = _homeNewsBussinessError


    fun getBussinessNews() = viewModelScope.launch(Dispatchers.IO) {
        newsRemoteDataSource.getDataNewsBussniness().let {
            if(it.isSuccessful){
                _homeNewsBussiness.postValue(it.body())
            }
            else{
                _homeNewsBussinessError.postValue(it.message())
            }

        }
    }

}