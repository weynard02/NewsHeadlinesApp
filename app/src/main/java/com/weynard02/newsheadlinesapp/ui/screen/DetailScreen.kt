package com.weynard02.newsheadlinesapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    title: String?,
    description: String?,
    urlToImage: String?,
    onBack: () -> Unit
) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text("News Detail")
                },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
            )
        }
    ){ innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).padding(horizontal = 8.dp)) {
            AsyncImage(
                alignment = Alignment.Center,
                model = urlToImage ?: "",
                contentDescription = null,
                modifier = Modifier.padding(8.dp).size(200.dp)
            )

            Text(text = title  ?: "", fontWeight = FontWeight.Medium, fontSize = 16.sp)

            Text(text = description  ?: "")

        }
    }

}