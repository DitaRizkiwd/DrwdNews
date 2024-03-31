package com.bcasandroid.drwdnews.presentation.science_screen.view_model

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
class ScienceViewModel @Inject constructor(private val newsRemoteDataSource: NewsRemoteDataSource):ViewModel(){
    private val _homeNewsScience = MutableLiveData<NewsResponse>()
    private val _homeNewsScienceError = MutableLiveData<String>()

    val homeScienceNews: LiveData<NewsResponse>
        get() = _homeNewsScience

    val homeNewsScienceError:LiveData<String>
        get() = _homeNewsScienceError

    fun getScienceNews()= viewModelScope.launch(Dispatchers.IO){
        newsRemoteDataSource.getDataNewsScience().let {
            if(it.isSuccessful){
                _homeNewsScience.postValue(it.body())
            }
            else{
                _homeNewsScienceError.postValue(it.message())
            }
        }
    }
}