package com.weynard02.newsheadlinesapp.navigation

import android.net.Uri

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Detail : Screen("detail/{title}/{description}/{urlToImage}") {
        fun createRoute(title: String, description: String, urlToImage: String): String {
            val uTitle = Uri.encode(title)
            val uDescription = Uri.encode(description)
            val uUrlToImage = Uri.encode(urlToImage)

            return "detail/$uTitle/$uDescription/$uUrlToImage"
        }
    }
}