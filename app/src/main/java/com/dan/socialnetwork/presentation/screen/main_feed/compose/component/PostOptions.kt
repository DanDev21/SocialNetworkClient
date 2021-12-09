package com.dan.socialnetwork.presentation.screen.main_feed.compose.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.dan.socialnetwork.presentation.ui.theme.Size_5
import com.dan.socialnetwork.presentation.ui.theme.Size_8

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
            text = "@$username",
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .clickable(onClick = onUsernameClick)
                .padding(
                    vertical = Size_5,
                    horizontal = Size_8
                )
        )
        EngagementButtons(
            isLiked = isLiked,
            like = like,
            comment = comment,
            share = share
        )
    }
}
