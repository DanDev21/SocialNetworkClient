package com.dan.socialnetwork.presentation.screen.activity.compose.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import com.dan.socialnetwork.R
import com.dan.socialnetwork.domain.model.Activity
import com.dan.socialnetwork.presentation.util.StringUtil
import com.dan.socialnetwork.presentation.util.Constants
import com.dan.socialnetwork.presentation.util.DateFormatter

@Composable
fun Item(
    modifier: Modifier = Modifier,
    activity: Activity
) {
    Card(
        shape = MaterialTheme.shapes.small,
        backgroundColor = MaterialTheme.colors.onSurface,
        elevation = Constants.Size.EXTRA_SMALL,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(Constants.Size.SMALL),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(fontWeight = FontWeight.Bold)

                    withStyle(boldStyle) {
                        append(
                            StringUtil
                                .format(activity.username)
                                .asUsername()
                                .get()
                        )
                    }
                    append(
                        " ${stringResource(getAction(activity.action))} "
                    )
                    withStyle(boldStyle) {
                        append(
                            stringResource(getTarget(activity.action))
                        )
                    }
                    append(".")
                },
                fontSize = Constants.Size.Text.SMALL
            )
            Text(
                text = DateFormatter.format(activity.timestamp, "MMM dd, HH:mm"),
                textAlign = TextAlign.Right,
                fontSize = Constants.Size.Text.SMALL
            )
        }
    }
}

@StringRes
private fun getAction(action: Activity.Action): Int = when (action) {
    is Activity.Action.CommentedOnPost -> R.string.commented_on
    is Activity.Action.LikedPost, Activity.Action.LikedComment -> R.string.liked
}

@StringRes
private fun getTarget(action: Activity.Action): Int = when (action) {
    is Activity.Action.LikedPost -> R.string.your_post
    is Activity.Action.CommentedOnPost, Activity.Action.LikedComment -> R.string.your_comment
}