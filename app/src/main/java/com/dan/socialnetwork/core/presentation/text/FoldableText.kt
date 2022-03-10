package com.dan.socialnetwork.core.presentation.text

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import com.dan.socialnetwork.util.Length
import com.dan.socialnetwork.core.presentation.Size

@Composable
fun FoldableText(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.body2,
    textColor: Color = MaterialTheme.colors.onBackground,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Length.Max.DESCRIPTION_LINES,
) {
    val folded = remember {
        mutableStateOf(true)
    }
    Box(
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .clickable {
                folded.value = !folded.value
            }
    ) {
        Text(
            text = text,
            style = textStyle,
            color = textColor,
            overflow = overflow,
            maxLines = if (folded.value) maxLines else 100,
            modifier = Modifier
                .padding(
                    horizontal = Size.SMALL
                )
        )
    }
}
