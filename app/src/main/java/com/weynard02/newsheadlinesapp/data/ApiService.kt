package com.weynard02.newsheadlinesapp.data

import com.weynard02.newsheadlinesapp.data.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines?country=id")
    suspend fun getTopHeadlines(@Query("apiKey") apiKey: String): NewsResponse
}