package com.dan.socialnetwork.presentation.screen.activity.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dan.socialnetwork.domain.model.Activity
import com.dan.socialnetwork.presentation.screen.activity.compose.component.Item
import com.dan.socialnetwork.presentation.screen.activity.viewmodel.ActivityViewModel
import com.dan.socialnetwork.presentation.util.Constants
import com.dan.socialnetwork.presentation.util.compose.spacer.DefaultEndSpacerV
import com.dan.socialnetwork.presentation.util.compose.spacer.DefaultMediumSpacerV
import kotlin.random.Random

@Composable
fun ActivityScreen(
    navController: NavController,
    viewModel: ActivityViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(all = Constants.Size.MEDIUM)
        ) {
            items(20) {
                Item(
                    activity = Activity(
                        username = "John",
                        action = if (Random.nextInt(2) == 0) {
                            Activity.Action.LikedPost
                        } else  {
                            Activity.Action.CommentedOnPost
                        }
                    )
                )
                DefaultMediumSpacerV()
            }

            item {
                DefaultEndSpacerV()
            }
        }
    }
}
