package com.weynard02.newsheadlinesapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.weynard02.newsheadlinesapp.data.response.NewsResponse
import com.weynard02.newsheadlinesapp.ui.common.UiState

class NewsRepository private constructor(
    private val apiService: ApiService
){
    fun getTopHeadlines(): LiveData<UiState<NewsResponse>> = liveData {
        emit(UiState.Loading)
        try {
            val response = apiService.getTopHeadlines()
            emit(UiState.Success(response))
        } catch (e: Exception) {
            emit(UiState.Error(e.message.toString()))
        }
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