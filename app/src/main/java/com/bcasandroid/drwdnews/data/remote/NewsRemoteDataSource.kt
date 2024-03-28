package com.bcasandroid.drwdnews.data.remote

import com.bcasandroid.drwdnews.data.response_model.NewsResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getDataNews() :Response<NewsResponse>
    suspend fun getDataNewsBussniness():Response<NewsResponse>
}