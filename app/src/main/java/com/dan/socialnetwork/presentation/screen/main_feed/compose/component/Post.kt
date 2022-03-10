package com.dan.socialnetwork.presentation.screen.main_feed.compose.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.dan.socialnetwork.R
import com.dan.socialnetwork.core.domain.model.Post
import com.dan.socialnetwork.core.presentation.Color
import com.dan.socialnetwork.core.presentation.Size
import com.dan.socialnetwork.core.presentation.text.FoldableText

@Composable
fun Post(
    post: Post,
    onClick: () -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = Size.MEDIUM),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.small)
                .clickable(onClick = onClick),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(R.drawable.profile_picture),
                contentDescription = stringResource(R.string.description_post_image),
                modifier = Modifier
                    .fillMaxWidth()
            )
            
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.On.Surface.Gray)
                    .padding(all = Size.SMALL),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
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

                FoldableText(
                    text = post.description,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                LikesComments(
                    likes = post.likes,
                    comments = post.comments,
                    textStyle = MaterialTheme.typography.h3,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = Size.SMALL)
                )
            }
        }
    }
}
