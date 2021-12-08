package com.dan.socialnetwork.presentation.screen.main_feed.compose.component

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dan.socialnetwork.R
import com.dan.socialnetwork.domain.model.Post
import com.dan.socialnetwork.domain.util.Constants
import com.dan.socialnetwork.presentation.ui.theme.Gray_on_sfc
import com.dan.socialnetwork.presentation.ui.theme.Size_16
import com.dan.socialnetwork.presentation.ui.theme.Size_24
import com.dan.socialnetwork.presentation.ui.theme.Size_8

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
                .shadow(7.dp)
                .background(Gray_on_sfc)
        ) {
            Image(
                painter = painterResource(R.drawable.profile_picture),
                contentDescription = stringResource(R.string.description_post_image),
            )
            
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Size_16)
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

                Spacer(modifier = Modifier.height(Size_16))

                Text(
                    text = post.description,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = Constants.Max.DESCRIPTION_LINES,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier
                )

                Spacer(modifier = Modifier.height(Size_16))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(
                            id = R.string.x_likes,
                            post.likes
                        ),
                        style = MaterialTheme.typography.h3
                    )

                    Text(
                        text = stringResource(
                            id = R.string.x_comments,
                            post.comments
                        ),
                        style = MaterialTheme.typography.h3
                    )
                }
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
