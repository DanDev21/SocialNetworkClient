package com.dan.socialnetwork.presentation.screen.main_feed.compose.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.dan.socialnetwork.R
import com.dan.socialnetwork.core.presentation.Size
import com.dan.socialnetwork.core.presentation.button.LikeButton
import com.dan.socialnetwork.core.presentation.spacer.DefaultMediumSpacerH

@Composable
fun EngagementButtons(
    modifier: Modifier = Modifier,
    iconsSize: Dp = Size.Image.DEFAULT,
    isLiked: Boolean = false,
    like: (Boolean) -> Unit,
    comment: () -> Unit,
    share: () -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LikeButton(
            iconsSize = iconsSize,
            isLiked = isLiked,
            onClick = like
        )

        DefaultMediumSpacerH()

        IconButton(
            modifier = Modifier
                .size(iconsSize),
            onClick = {
                comment()
            }
        ) {
            Icon(
                imageVector = Icons.Outlined.Comment,
                contentDescription = stringResource(R.string.description_comment)
            )
        }

        DefaultMediumSpacerH()

        IconButton(
            modifier = Modifier
                .size(iconsSize),
            onClick = {
                share()
            }
        ) {
            Icon(
                imageVector = Icons.Outlined.Share,
                contentDescription = stringResource(R.string.description_share)
            )
        }
    }
}
