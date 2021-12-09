package com.dan.socialnetwork.presentation.screen.main_feed.compose.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.dan.socialnetwork.R

@Composable
fun LikesComments(
    modifier: Modifier = Modifier,
    likes: Int,
    comments: Int,
    textStyle: TextStyle
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        Text(
            text = stringResource(
                id = R.string.x_likes,
                likes
            ),
            style = textStyle
        )

        Text(
            text = stringResource(
                id = R.string.x_comments,
                comments
            ),
            style = textStyle
        )
    }
}
