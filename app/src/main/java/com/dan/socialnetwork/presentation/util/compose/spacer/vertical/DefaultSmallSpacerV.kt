package com.dan.socialnetwork.presentation.util.compose.spacer.vertical

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dan.socialnetwork.presentation.util.Constants

@Composable
fun DefaultSmallSpacerV() {
    Spacer(modifier = Modifier.height(Constants.Size.SMALL))
}
