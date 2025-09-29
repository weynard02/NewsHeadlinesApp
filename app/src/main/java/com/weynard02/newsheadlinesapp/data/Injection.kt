package com.weynard02.newsheadlinesapp.data

import android.content.Context

object Injection {
    fun provideRepository(context: Context) : NewsRepository {
        val apiService = ApiConfig.getApiService()
        return NewsRepository.getInstance(apiService)
    }
}