package com.weynard02.newsheadlinesapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.weynard02.newsheadlinesapp.ViewModelFactory
import com.weynard02.newsheadlinesapp.ui.theme.NewsHeadlinesAppTheme


@Composable
fun NewsHeadlinesApp(
    modifier: Modifier = Modifier,
)  {
//    Box(modifier = modifier) {
//        val scope = rememberCoroutineScope()
//        val listState = rememberLazyListState()
//
//        LazyColumn(
//            state = listState
//        ) {
//
//        }
//    }
    Text("Hello")
}

@Preview(showBackground = true)
@Composable
fun NewsHeadlinesAppPreview() {
    NewsHeadlinesAppTheme {
        NewsHeadlinesApp()
    }
}