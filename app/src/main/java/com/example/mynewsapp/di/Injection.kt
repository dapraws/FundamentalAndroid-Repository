package com.example.mynewsapp.di

import android.content.Context
import com.example.mynewsapp.data.NewsRepository
import com.example.mynewsapp.data.local.room.NewsDatabase
import com.example.mynewsapp.data.remote.retrofit.ApiConfig
import com.example.mynewsapp.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): NewsRepository {
        val apiService = ApiConfig.getApiService()
        val database = NewsDatabase.getInstance(context)
        val dao = database.newsDao()
        val appExecutors = AppExecutors()
        return NewsRepository.getInstance(apiService, dao, appExecutors)
    }
}