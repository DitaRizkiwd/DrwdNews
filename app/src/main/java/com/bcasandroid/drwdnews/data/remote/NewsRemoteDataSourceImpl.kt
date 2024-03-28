package com.bcasandroid.drwdnews.data.remote

import com.bcasandroid.drwdnews.data.NewsService
import com.bcasandroid.drwdnews.data.response_model.NewsResponse
import com.bcasandroid.drwdnews.utils.Constants
import retrofit2.Response
import javax.inject.Inject

class NewsRemoteDataSourceImpl @Inject constructor(val service : NewsService) : NewsRemoteDataSource {
    override suspend fun getDataNews(): Response<NewsResponse> {
        return service.getNews("","", Constants.API_KEY)
    }

    override suspend fun getDataNewsBussniness(): Response<NewsResponse> {
        return service.getNews(Constants.COUNTRY,"business", Constants.API_KEY)
    }

    override suspend fun getDataNewsEntertainment(): Response<NewsResponse> {
        return service.getNews(Constants.COUNTRY,"entertainment", Constants.API_KEY)
    }

    override suspend fun getDataNewsScience(): Response<NewsResponse> {
        return service.getNews(Constants.COUNTRY,"science", Constants.API_KEY)
    }
}