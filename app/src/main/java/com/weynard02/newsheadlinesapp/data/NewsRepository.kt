package com.weynard02.newsheadlinesapp.data

import com.weynard02.newsheadlinesapp.BuildConfig
import com.weynard02.newsheadlinesapp.data.response.ArticlesItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepository private constructor(
    private val apiService: ApiService
){
    fun getTopHeadlines(): Flow<List<ArticlesItem>> = flow {
        val response = apiService.getTopHeadlines(BuildConfig.API_KEY).articles
        emit(response)
    }

    companion object {
        @Volatile
        private var instance: NewsRepository? = null
        fun getInstance(
            apiService: ApiService
        ): NewsRepository =
            instance ?: synchronized(this) {
                instance ?: NewsRepository(apiService)
            }.also { instance = it }
    }
}