package com.dan.socialnetwork.presentation.util.compose.spacer.horizontal

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dan.socialnetwork.presentation.util.Constants

@Composable
fun DefaultMediumSpacerH() {
    Spacer(modifier = Modifier.width(Constants.Size.MEDIUM))
}