package com.dan.socialnetwork.core.presentation.text

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle

@Composable
fun Link(
    modifier: Modifier = Modifier,
    @StringRes textStringId: Int,
    @StringRes linkStringId: Int,
    onClick: () -> Unit,
) {
    Text(
        text = buildAnnotatedString {
            append(stringResource(id = textStringId))
            append(" ")
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.primary
                )
            ) {
                append(stringResource(id = linkStringId))
            }
        },
        modifier = modifier
            .clickable {
                onClick()
            }
    )
}
