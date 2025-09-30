package com.weynard02.newsheadlinesapp.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.weynard02.newsheadlinesapp.ui.theme.NewsHeadlinesAppTheme

@Composable
fun NewsListItem(
    title: String,
    description: String,
    urlToImage: String,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = urlToImage,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(8.dp).size(100.dp)
            )
            Column(
                modifier = Modifier.fillMaxWidth().weight(1f).padding(start = 16.dp)
            ) {
                Text(text = title, fontWeight = FontWeight.Medium)
                Text(text = description)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsListItemPreview() {
    NewsHeadlinesAppTheme {
        NewsListItem(
            title = "Title",
            description = "Description",
            urlToImage = "https://i.scdn.co/image/ab6761610000e5eb877d4c061d08c040974224be"
        )

    }
}