package com.dan.socialnetwork.presentation.screen.main_feed.compose.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import com.dan.socialnetwork.domain.util.StringUtil
import com.dan.socialnetwork.presentation.util.Constants
import com.dan.socialnetwork.presentation.util.compose.spacer.DefaultSmallSpacerH

@Composable
fun UserProfileLink(
    modifier: Modifier = Modifier,
    username: String,
    textStyle: TextStyle = MaterialTheme.typography.h3,
    imageUrl: String,
    imageSize: Dp = Constants.Size.Image.PROFILE_PICTURE_EXTRA_SMALL,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .clickable(onClick = onClick)
            .padding(
                vertical = Constants.Size.EXTRA_SMALL,
                horizontal = Constants.Size.SMALL
            ),
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        ProfilePicture(
            imageUrl = "",
            imageSize = imageSize,
        )
        
        DefaultSmallSpacerH()

        Text(
            text = "@${StringUtil.crop(username)}",
            style = textStyle,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
