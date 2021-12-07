package com.dan.socialnetwork.presentation.screen.login.compose.component

import androidx.compose.foundation.clickable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.dan.socialnetwork.R

@Composable
fun SignUpLink(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Text(
        text = buildAnnotatedString {
            append(
                stringResource(id = R.string.question_sign_up)
            )
            append(" ")
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.primary
                )
            ) {
                append(
                    stringResource(id = R.string.sign_up)
                )
            }
        },
        modifier = modifier
            .clickable {
                onClick()
            }
    )
}
