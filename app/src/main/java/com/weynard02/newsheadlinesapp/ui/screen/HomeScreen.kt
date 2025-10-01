package com.weynard02.newsheadlinesapp.ui.screen

import android.graphics.Color.red
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.weynard02.newsheadlinesapp.ViewModelFactory
import com.weynard02.newsheadlinesapp.data.Injection
import com.weynard02.newsheadlinesapp.data.response.ArticlesItem
import com.weynard02.newsheadlinesapp.ui.NewsViewModel
import com.weynard02.newsheadlinesapp.ui.common.UiState
import com.weynard02.newsheadlinesapp.ui.component.NewsListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: NewsViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))
    ),
    modifier: Modifier = Modifier,
    navigateToDetail: (String, String, String) -> Unit,
)  {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text("Top News Headlines")
                },

            )
        }
    ) { innerPadding ->
        Box(modifier = modifier.padding(innerPadding)) {
            val listState = rememberLazyListState()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

            when (uiState) {
                is UiState.Loading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }

                is UiState.Error -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text("Error loading news", fontWeight = FontWeight.Medium, color = Color(255, 0, 0))
                        }
                    }
                }

                is UiState.Success<List<ArticlesItem>> -> {
                    val articles = (uiState as UiState.Success<List<ArticlesItem>>).data

                    if (articles.isEmpty()) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("No news available", fontWeight = FontWeight.Medium)
                        }
                    } else {
                        LazyColumn(
                            state = listState
                        ) {
                            items(articles) {
                                NewsListItem(
                                    title = it.title.toString(),
                                    description = it.description.toString(),
                                    urlToImage = it.urlToImage.toString(),
                                    modifier = Modifier.clickable {
                                        navigateToDetail(
                                            it.title.toString(),
                                            it.description.toString(),
                                            it.urlToImage.toString()
                                        )
                                    }
                                )
                            }
                        }
                    }

                }

            }


        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    NewsHeadlinesAppTheme {
//        HomeScreen()
//    }
//}