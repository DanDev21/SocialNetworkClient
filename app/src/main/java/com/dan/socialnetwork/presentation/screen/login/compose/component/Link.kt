package com.dan.socialnetwork.presentation.screen.login.compose.component

import androidx.compose.foundation.clickable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle

@Composable
fun Link(
    modifier: Modifier = Modifier,
    text: String,
    link: String,
    onClick: () -> Unit,
) {
    Text(
        text = buildAnnotatedString {
            append(text)
            append(" ")
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.primary
                )
            ) {
                append(link)
            }
        },
        modifier = modifier
            .clickable {
                onClick()
            }
    )
}
