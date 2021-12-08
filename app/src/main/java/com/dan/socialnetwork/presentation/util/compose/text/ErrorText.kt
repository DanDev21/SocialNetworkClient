package com.dan.socialnetwork.presentation.util.compose.text

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun ErrorText(
    modifier: Modifier = Modifier,
    message: String,
) {
    Text(
        text = message,
        style = MaterialTheme.typography.body2,
        color = MaterialTheme.colors.error,
        textAlign = TextAlign.End,
        modifier = modifier
            .fillMaxWidth()
    )
}