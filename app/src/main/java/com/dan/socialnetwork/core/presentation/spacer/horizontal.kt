package com.dan.socialnetwork.core.presentation.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dan.socialnetwork.core.presentation.Size

@Composable
fun DefaultSmallSpacerH() {
    Spacer(modifier = Modifier.width(Size.SMALL))
}

@Composable
fun DefaultMediumSpacerH() {
    Spacer(modifier = Modifier.width(Size.MEDIUM))
}

@Composable
fun DefaultLargeSpacerH() {
    Spacer(modifier = Modifier.width(Size.LARGE))
}
