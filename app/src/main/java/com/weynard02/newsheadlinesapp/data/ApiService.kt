package com.weynard02.newsheadlinesapp.data

import com.weynard02.newsheadlinesapp.data.response.NewsResponse
import retrofit2.http.GET

interface ApiService {
    @GET("top-headlines?country=id")
    suspend fun getTopHeadlines(): NewsResponse
}