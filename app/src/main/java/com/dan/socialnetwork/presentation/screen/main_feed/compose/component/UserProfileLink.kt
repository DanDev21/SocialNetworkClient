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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.dan.socialnetwork.core.presentation.Size
import com.dan.socialnetwork.util.StringUtil
import com.dan.socialnetwork.core.presentation.spacer.DefaultSmallSpacerH

@Composable
fun UserProfileLink(
    modifier: Modifier = Modifier,
    username: String,
    textStyle: TextStyle = MaterialTheme.typography.h3,
    imageUrl: String,
    imageSize: Dp = Size.Image.PROFILE_PICTURE_EXTRA_SMALL,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .clickable(onClick = onClick)
            .padding(
                vertical = Size.EXTRA_SMALL,
                horizontal = Size.SMALL
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
            text = StringUtil
                .format(username)
                .asUsername()
                .get(),
            style = textStyle,
            textAlign = TextAlign.Center
        )
    }
}
