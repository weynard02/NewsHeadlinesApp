package com.weynard02.newsheadlinesapp.ui

import android.R.attr.type
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.weynard02.newsheadlinesapp.ui.theme.NewsHeadlinesAppTheme
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.weynard02.newsheadlinesapp.navigation.Screen
import com.weynard02.newsheadlinesapp.ui.screen.DetailScreen
import com.weynard02.newsheadlinesapp.ui.screen.HomeScreen


@Composable
fun NewsHeadlinesApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
)  {
    Scaffold(
        modifier = modifier
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToDetail = { title, description, urlToImage ->
                        navController.navigate(Screen.Detail.createRoute(title, description, urlToImage))

                    }
                )
            }

            composable(Screen.Detail.route, arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("description") { type = NavType.StringType },
                navArgument("urlToImage") { type = NavType.StringType },
            ))
            {
                val title = it.arguments?.getString("title").orEmpty()
                val description = it.arguments?.getString("description").orEmpty()
                val urlToImage = it.arguments?.getString("urlToImage")
                    ?.ifBlank { null }

                DetailScreen(
                    title = title,
                    description = description,
                    urlToImage = urlToImage,
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsHeadlinesAppPreview() {
    NewsHeadlinesAppTheme {
        NewsHeadlinesApp()
    }
}