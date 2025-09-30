package com.weynard02.newsheadlinesapp.ui.screen

import android.R.attr.data
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@Composable
fun HomeScreen(
    viewModel: NewsViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))
    ),
    modifier: Modifier = Modifier,
    navigateToDetail: (String, String, String) -> Unit,
)  {
    Box(modifier = modifier) {
        val listState = rememberLazyListState()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        when(uiState) {
            is UiState.Loading -> {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
            is UiState.Error -> {
                Column(
                    modifier = Modifier.align(Alignment.Center).padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text("Error loading news", fontWeight = FontWeight.Medium)
                }
            }
            is UiState.Success<List<ArticlesItem>> -> {
                LazyColumn(
                    state = listState
                ) {
                    items((uiState as UiState.Success<List<ArticlesItem>>).data) {
                        NewsListItem(
                            title = it.title.toString(),
                            description = it.description.toString(),
                            urlToImage = it.urlToImage.toString(),
                            modifier = Modifier.clickable {
                                navigateToDetail(it.title.toString(), it.description.toString(), it.urlToImage.toString())
                            }
                        )
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