package com.weynard02.newsheadlinesapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weynard02.newsheadlinesapp.data.NewsRepository
import com.weynard02.newsheadlinesapp.data.response.ArticlesItem
import com.weynard02.newsheadlinesapp.data.response.NewsResponse
import com.weynard02.newsheadlinesapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<ArticlesItem>>>  = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<ArticlesItem>>>
        get() = _uiState

    init {
        getTopHeadlines()
    }

    fun getTopHeadlines() {
        viewModelScope.launch {
            newsRepository.getTopHeadlines()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { articles ->
                    _uiState.value = UiState.Success(articles)
                }
        }
    }
}

