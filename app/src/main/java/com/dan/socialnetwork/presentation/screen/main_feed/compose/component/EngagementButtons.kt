package com.dan.socialnetwork.presentation.screen.main_feed.compose.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dan.socialnetwork.R
import com.dan.socialnetwork.presentation.ui.theme.Gray_on_bg
import com.dan.socialnetwork.presentation.ui.theme.Size_16

@Composable
fun EngagementButtons(
    modifier: Modifier = Modifier,
    iconsSize: Dp = 30.dp,
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
        IconButton(
            modifier = Modifier
                .size(iconsSize),
            onClick = {
                like(!isLiked)
            }
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                tint = getLikeIconTint(isLiked),
                contentDescription = stringResource(getLikeOrNotDescriptionId(isLiked))
            )
        }

        Spacer(modifier = Modifier.width(Size_16))

        IconButton(
            modifier = Modifier
                .size(iconsSize),
            onClick = {
                comment()
            }
        ) {
            Icon(
                imageVector = Icons.Filled.Comment,
                contentDescription = stringResource(R.string.description_comment)
            )
        }

        Spacer(modifier = Modifier.width(Size_16))

        IconButton(
            modifier = Modifier
                .size(iconsSize),
            onClick = {
                share()
            }
        ) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = stringResource(R.string.description_share)
            )
        }
    }
}

private fun getLikeIconTint(like: Boolean): Color =
    if (like) Color.Red
    else Gray_on_bg

@StringRes
private fun getLikeOrNotDescriptionId(like: Boolean): Int =
    if (like) R.string.description_unlike
    else R.string.description_like
