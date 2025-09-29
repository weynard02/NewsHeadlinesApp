package com.weynard02.newsheadlinesapp.ui

import androidx.lifecycle.ViewModel
import com.weynard02.newsheadlinesapp.data.NewsRepository

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    fun getTopHeadlines() = newsRepository.getTopHeadlines()
}

