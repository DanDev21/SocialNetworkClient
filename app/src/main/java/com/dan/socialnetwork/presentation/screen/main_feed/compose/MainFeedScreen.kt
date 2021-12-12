package com.dan.socialnetwork.presentation.screen.main_feed.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.dan.socialnetwork.presentation.screen.main_feed.compose.component.Post
import com.dan.socialnetwork.presentation.util.Screen

@Composable
fun MainFeedScreen(
    navController: NavController,
) {
    Post(
        post = com.dan.socialnetwork.domain.model.Post(
            "Dan",
            "",
            "",
            "this is the firadk asdksamdk sadkmaskmdka daksmdkmsadkmkasmdkkad asdmkamdkmakdka" +
                    "maksmdkasmdksakmdksadskdmka dakdmkakdmas dkamdad asmdkaskdmdamd" +
                    "askdkamda askdmkakdmkasmsmdasd a dkamdkas" +
                    "asmdkakmsdksmaskdmkaskdmkasmd a dkada dkmasmdkda damk skdas" +
                    "kasmdkamkdmkasmdkmdaksmdka dakkdmakkdmakmdka " +
                    "asdmdasmdasko",
            12,
            34
        ),
        onClick = {
            navController.navigate(Screen.PostDetails.route)
        }
    )
}
