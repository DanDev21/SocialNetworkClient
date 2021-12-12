package com.dan.socialnetwork.presentation.screen.main_feed.compose.component

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

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
        UserProfileLink(
            username = username,
            imageUrl = "",
            onClick = onUsernameClick
        )
        EngagementButtons(
            isLiked = isLiked,
            like = like,
            comment = comment,
            share = share
        )
    }
}
