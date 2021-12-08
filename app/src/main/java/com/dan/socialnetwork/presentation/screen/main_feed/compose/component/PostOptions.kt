package com.dan.socialnetwork.presentation.screen.main_feed.compose.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PostOptions(
    modifier: Modifier = Modifier,
    username: String,
    onUsernameClick: () -> Unit,
    isLiked: Boolean = false,
    like: (Boolean) -> Unit,
    comment: () -> Unit,
    share: () -> Unit,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = username,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primary,
            modifier = Modifier.
                    clickable(onClick = onUsernameClick)
        )
        EngagementButtons(
            modifier = Modifier
                .width(100.dp),
            isLiked = isLiked,
            like = like,
            comment = comment,
            share = share
        )
    }
}
