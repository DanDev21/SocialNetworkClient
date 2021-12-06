package com.dan.socialnetwork.presentation.util.compose.text_field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun StandardTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = "",
    onValueChange: (String) -> Unit
) {
    TextField(
        value = text,
        placeholder = {
              Text(
                  text = hint,
                  style = MaterialTheme.typography.body1
              )
        },
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
    )
}