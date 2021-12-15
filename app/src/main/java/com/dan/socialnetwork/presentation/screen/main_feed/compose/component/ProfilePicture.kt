package com.dan.socialnetwork.presentation.screen.main_feed.compose.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.dan.socialnetwork.R
import com.dan.socialnetwork.presentation.ui.theme.Gray_ht

import com.dan.socialnetwork.presentation.util.Constants

@Composable
fun ProfilePicture(
    modifier: Modifier = Modifier,
    imageUrl: String,
    imageSize: Dp = Constants.Size.Image.PROFILE_PICTURE
) {
    Image(
        painter = painterResource(R.drawable.profile_picture),
        contentDescription = stringResource(R.string.description_profile_picture),
        modifier = modifier
            .size(imageSize)
            .clip(CircleShape)
            .border(
                width = Constants.Width.Border.PROFILE_PICTURE,
                color = Gray_ht,
                shape = CircleShape
            )
    )
}