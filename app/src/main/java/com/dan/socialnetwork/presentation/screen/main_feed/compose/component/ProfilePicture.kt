package com.dan.socialnetwork.presentation.screen.main_feed.compose.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.dan.socialnetwork.R
import com.dan.socialnetwork.core.presentation.Color
import com.dan.socialnetwork.core.presentation.Size
import com.dan.socialnetwork.core.presentation.Width

@Composable
fun ProfilePicture(
    modifier: Modifier = Modifier,
    imageUrl: String,
    imageSize: Dp = Size.Image.PROFILE_PICTURE
) {
    Image(
        painter = painterResource(R.drawable.profile_picture),
        contentDescription = stringResource(R.string.description_profile_picture),
        modifier = modifier
            .size(imageSize)
            .clip(CircleShape)
            .border(
                width = Width.Border.PROFILE_PICTURE,
                color = Color.Hint.Gray,
                shape = CircleShape
            )
    )
}
