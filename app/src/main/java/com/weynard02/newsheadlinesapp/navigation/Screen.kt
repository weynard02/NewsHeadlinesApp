package com.weynard02.newsheadlinesapp.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Detail : Screen("detail/{title}/{description}/{urlToImage}") {
        fun createRoute(title: String, description: String, urlToImage: String) = "detail/$title/$description/$urlToImage"
    }
}