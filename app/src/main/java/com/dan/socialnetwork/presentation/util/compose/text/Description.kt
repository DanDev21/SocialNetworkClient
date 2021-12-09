package com.dan.socialnetwork.presentation.util.compose.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import com.dan.socialnetwork.R
import com.dan.socialnetwork.domain.util.Constants
import com.dan.socialnetwork.presentation.ui.theme.Gray_ht

@Composable
fun Description(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        text = buildAnnotatedString {
            append(text)
            withStyle(
                SpanStyle(
                    color = Gray_ht
                )
            ) {
                append(stringResource(R.string.read_more))
            }
        },
        overflow = TextOverflow.Ellipsis,
        maxLines = Constants.Max.DESCRIPTION_LINES,
        style = MaterialTheme.typography.body2,
        modifier = modifier
    )
}
