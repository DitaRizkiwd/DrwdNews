package com.bcasandroid.drwdnews.presentation.entertainment_screen.view_model

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
class EntertainmentViewModel @Inject constructor(private val newsRemoteDataSource: NewsRemoteDataSource):ViewModel() {
    private val _homeNewsEntertainment = MutableLiveData<NewsResponse>()
    private val _homehomeNewsEntertainmentError = MutableLiveData<String>()

    val homeEntertainmentNews:LiveData<NewsResponse>
        get()=_homeNewsEntertainment

    val homeNewsEntertainmentError: LiveData<String>
        get() = _homehomeNewsEntertainmentError

    fun getEntertainmnetNews() = viewModelScope.launch(Dispatchers.IO){
        newsRemoteDataSource.getDataNewsEntertainment().let {
            if(it.isSuccessful){
                _homeNewsEntertainment.postValue(it.body())
            }
            else{
                _homehomeNewsEntertainmentError.postValue(it.message())
            }
        }
    }
}
