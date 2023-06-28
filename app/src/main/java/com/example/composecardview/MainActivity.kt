package com.example.composecardview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.composecardview.domain.CardItem
import com.example.composecardview.ui.theme.ComposeCardViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCardViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CardListView(
                        items = listOf(
                            CardItem(
                                source = "https://picsum.photos/200/",
                                title = "wall",
                                desc = "반갑습니다."
                            ),
                            CardItem(
                                source = "https://picsum.photos/300/",
                                title = "wall2",
                                desc = "반갑습니다.2"
                            ),
                            CardItem(
                                source = "https://picsum.photos/400/",
                                title = "wall3",
                                desc = "반갑습니다.3"
                            )
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun CardView(item: CardItem) {
    Card(
        modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 8.dp).fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = CardDefaults.elevatedShape
    ) {
        AsyncImage(
            model = item.source,
            contentDescription = "image",
            modifier = Modifier.padding(start = 8.dp, top = 8.dp).fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = item.title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = item.desc,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreView() {
    ComposeCardViewTheme {
        CardView(
            CardItem(
                source = "https://picsum.photos/400/",
                title = "wall",
                desc = "반갑습니다."
            )
        )
    }
}

@Composable
fun CardListView(items: List<CardItem>) {
    LazyColumn {
        items(items) {
            CardView(item = it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeCardViewTheme {
            CardListView(
                items = listOf(
                    CardItem(
                        source = "https://picsum.photos/200/",
                        title = "wall",
                        desc = "반갑습니다."
                    ),
                    CardItem(
                        source = "https://picsum.photos/300/",
                        title = "wall2",
                        desc = "반갑습니다.2"
                    ),
                    CardItem(
                        source = "https://picsum.photos/400/",
                        title = "wall3",
                        desc = "반갑습니다.3"
                    )
                )
            )
    }
}