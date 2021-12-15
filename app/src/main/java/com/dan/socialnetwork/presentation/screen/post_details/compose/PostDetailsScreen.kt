package com.dan.socialnetwork.presentation.screen.post_details.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.dan.socialnetwork.R
import com.dan.socialnetwork.domain.model.Post
import com.dan.socialnetwork.presentation.screen.main_feed.compose.component.UserProfileLink
import com.dan.socialnetwork.presentation.screen.post_details.compose.component.Comment
import com.dan.socialnetwork.presentation.util.Constants
import com.dan.socialnetwork.presentation.util.compose.spacer.*
import com.dan.socialnetwork.presentation.util.compose.text.FoldableText

@Composable
fun PostDetailsScreen(
    navController: NavController,
    post: Post,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = Constants.Size.LARGE,
                            vertical = Constants.Size.SMALL
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DefaultMediumSpacerV()

                    Image(
                        painter = painterResource(R.drawable.profile_picture),
                        contentDescription = stringResource(R.string.description_post_image),
                        modifier = Modifier
                            .clip(MaterialTheme.shapes.small),
                    )

                    DefaultSmallSpacerV()

                    UserProfileLink(
                        username = post.username,
                        imageUrl = "",
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = {}
                    )

                    DefaultLargeSpacerV()

                    FoldableText(text = post.description)

                    DefaultMediumSpacerV()
                }
            }

            items(20) {
                Comment(
                    comment = com.dan.socialnetwork.domain.model.Comment(
                        username = "Dan Sabau $it",
                        text = "askdniad adsniadm adiadkmaidaijdiadiasjidjasjdiaa\nsk akdmadasd" +
                                "asdaisdij asdjias aisdjiajda\n" +
                                "adoadsiajdiaidjajidjiaidjiasjidjasijdiasj"
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = Constants.Size.LARGE,
                            vertical = Constants.Size.SMALL
                        ),
                    onClick = {},
                    like = {},
                )
            }

            item {
                DefaultEndSpacerV()
            }
        }
    }
}
