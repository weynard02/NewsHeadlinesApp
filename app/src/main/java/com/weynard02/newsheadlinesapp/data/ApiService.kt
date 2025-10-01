package com.weynard02.newsheadlinesapp.data

import com.weynard02.newsheadlinesapp.data.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    // Last time I checked, there was no news in id, you can change to us
    @GET("top-headlines?country=id")
    suspend fun getTopHeadlines(@Query("apiKey") apiKey: String): NewsResponse
}