package com.dan.socialnetwork.presentation.screen.main_feed.compose.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dan.socialnetwork.R
import com.dan.socialnetwork.domain.model.Post
import com.dan.socialnetwork.presentation.ui.theme.Gray_on_sfc
import com.dan.socialnetwork.presentation.ui.theme.Size_16
import com.dan.socialnetwork.presentation.ui.theme.Size_8
import com.dan.socialnetwork.presentation.util.compose.text.Description

@Composable
fun Post(
    post: Post,
    profilePictureSize: Dp = 56.dp
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Size_16),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .offset(
                    y = profilePictureSize / 2f
                )
                .clip(MaterialTheme.shapes.small)
                .background(Gray_on_sfc)
        ) {
            Image(
                painter = painterResource(R.drawable.profile_picture),
                contentDescription = stringResource(R.string.description_post_image),
            )
            
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.medium)
                    .padding(
                        top = Size_8,
                        start = Size_16,
                        end = Size_16,
                        bottom = Size_16
                    )
            ) {
                PostOptions(
                    username = "Dan",
                    onUsernameClick = {},
                    like = {},
                    comment = {},
                    share = {},
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Description(
                    text = post.description,
                )

                Spacer(modifier = Modifier.height(Size_8))

                LikesComments(
                    likes = post.likes,
                    comments = post.comments,
                    textStyle = MaterialTheme.typography.h3,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = stringResource(R.string.description_profile_picture),
            modifier = Modifier
                .size(profilePictureSize)
                .clip(CircleShape)
                .align(Alignment.TopCenter)
        )
    }
}
