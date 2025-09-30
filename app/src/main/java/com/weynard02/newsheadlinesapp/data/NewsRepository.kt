package com.weynard02.newsheadlinesapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.weynard02.newsheadlinesapp.BuildConfig
import com.weynard02.newsheadlinesapp.data.response.ArticlesItem
import com.weynard02.newsheadlinesapp.data.response.NewsResponse
import com.weynard02.newsheadlinesapp.ui.common.UiState

class NewsRepository private constructor(
    private val apiService: ApiService
){
    suspend fun getTopHeadlines(): List<ArticlesItem> {
        val response = apiService.getTopHeadlines(BuildConfig.API_KEY).articles
        return response
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