package com.weynard02.newsheadlinesapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weynard02.newsheadlinesapp.data.NewsRepository
import com.weynard02.newsheadlinesapp.data.response.ArticlesItem
import com.weynard02.newsheadlinesapp.data.response.NewsResponse
import com.weynard02.newsheadlinesapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<ArticlesItem>>>(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        getTopHeadlines()
    }

    fun getTopHeadlines() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val data = newsRepository.getTopHeadlines()
                _uiState.value = UiState.Success(data)
            }
            catch (e: Exception)   {
                _uiState.value = UiState.Error(e.message.toString())
            }
        }
    }
}

