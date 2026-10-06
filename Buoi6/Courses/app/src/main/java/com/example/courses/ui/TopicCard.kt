package com.example.courses.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.courses.model.Topic
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Grain
import androidx.compose.ui.layout.ContentScale

@Composable
fun TopicCard(
    topic: Topic,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Row {
            Image(
                painter = painterResource(topic.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(68.dp)
                    .aspectRatio(1f)
            )
            Column(
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 16.dp,
                    end = 16.dp,
                    bottom = 8.dp
                )
            ) {
                Text(
                    text = stringResource(topic.name),
                    style = MaterialTheme.typography.bodyMedium
                )

                Row(
                    modifier = Modifier.padding(top = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Grain,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )

                    Text(
                        text = topic.availableCourses.toString(),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}