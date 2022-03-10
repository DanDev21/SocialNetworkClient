package com.dan.socialnetwork.core.presentation.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dan.socialnetwork.core.presentation.Size

@Composable
fun DefaultSmallSpacerV() {
    Spacer(modifier = Modifier.height(Size.SMALL))
}

@Composable
fun DefaultMediumSpacerV() {
    Spacer(modifier = Modifier.height(Size.MEDIUM))
}

@Composable
fun DefaultLargeSpacerV() {
    Spacer(modifier = Modifier.height(Size.LARGE))
}

@Composable
fun DefaultEndSpacerV() {
    Spacer(modifier = Modifier.height(100.dp))
}
