package com.dan.socialnetwork.presentation.util.compose.button

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.dan.socialnetwork.R
import com.dan.socialnetwork.presentation.ui.theme.Gray_on_bg

@Composable
fun LikeButton(
    modifier: Modifier = Modifier,
    iconsSize: Dp,
    isLiked: Boolean = false,
    onClick: (Boolean) -> Unit
) {
    IconButton(
        modifier = modifier
            .size(iconsSize),
        onClick = {
            onClick(!isLiked)
        }
    ) {
        Icon(
            imageVector = Icons.Outlined.Favorite,
            tint = getIconTint(isLiked),
            contentDescription = stringResource(getDescriptionId(isLiked))
        )
    }
}

private fun getIconTint(like: Boolean): Color =
    if (like)   Color.Red
    else        Gray_on_bg

@StringRes
private fun getDescriptionId(like: Boolean): Int =
    if (like)   R.string.description_unlike
    else        R.string.description_like
