package com.weynard02.newsheadlinesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.weynard02.newsheadlinesapp.ui.NewsHeadlinesApp
import com.weynard02.newsheadlinesapp.ui.theme.NewsHeadlinesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsHeadlinesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    NewsHeadlinesApp()
                }
            }
        }
    }
}
