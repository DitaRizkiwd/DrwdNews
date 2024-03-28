package com.bcasandroid.drwdnews.module

import com.bcasandroid.drwdnews.data.NewsService
import com.bcasandroid.drwdnews.data.remote.NewsRemoteDataSource
import com.bcasandroid.drwdnews.data.remote.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Singleton
    @Provides
    fun provideMenuDashboardRemoteDataSource(service : NewsService): NewsRemoteDataSource{
        return NewsRemoteDataSourceImpl(service)
    }
}