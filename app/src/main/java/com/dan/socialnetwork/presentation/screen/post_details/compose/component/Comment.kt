package com.dan.socialnetwork.presentation.screen.post_details.compose.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dan.socialnetwork.R
import com.dan.socialnetwork.core.domain.model.Comment
import com.dan.socialnetwork.core.presentation.Size
import com.dan.socialnetwork.presentation.screen.main_feed.compose.component.UserProfileLink
import com.dan.socialnetwork.core.presentation.button.LikeButton
import com.dan.socialnetwork.core.presentation.spacer.DefaultSmallSpacerH
import com.dan.socialnetwork.core.presentation.text.FoldableText

@Composable
fun Comment(
    modifier: Modifier = Modifier,
    comment: Comment,
    onClick: () -> Unit,
    like: (Boolean) -> Unit
) {
    Card(
        modifier = modifier,
        elevation = 5.dp,
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.onSurface
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = Size.MEDIUM,
                    vertical = Size.SMALL
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                UserProfileLink(
                    username = comment.username,
                    imageUrl = "",
                    onClick = onClick
                )
                Text(
                    text = "2 days ago",
                    style = MaterialTheme.typography.body2
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FoldableText(
                    text = comment.text,
                    modifier = Modifier
                        .weight(9f)
                )

                DefaultSmallSpacerH()
                
                LikeButton(
                    iconsSize = Size.Image.DEFAULT,
                    isLiked = false,
                    onClick = like,
                    modifier = Modifier
                        .weight(1f)
                )
            }

            Text(
                text = stringResource(
                    id = R.string.x_likes,
                    comment.likes
                ),
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .padding(all = Size.SMALL)
            )
        }
    }
}
