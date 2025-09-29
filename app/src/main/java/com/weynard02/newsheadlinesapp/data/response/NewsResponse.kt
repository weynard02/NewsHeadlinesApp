package com.weynard02.newsheadlinesapp.data.response

import com.google.gson.annotations.SerializedName

data class NewsResponse(

	@field:SerializedName("articles")
	val articles: List<ArticlesItem>
)

data class ArticlesItem(

	@field:SerializedName("urlToImage")
	val urlToImage: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("title")
	val title: String
)
