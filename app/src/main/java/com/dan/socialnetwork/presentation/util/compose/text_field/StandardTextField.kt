package com.dan.socialnetwork.presentation.util.compose.text_field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.input.KeyboardType
import com.dan.socialnetwork.domain.util.Constants

@Composable
fun StandardTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = "",
    maxLength: Int = 20,
    isError: Boolean = false,
    keyBoardType: KeyboardType = KeyboardType.Text,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = text,
        singleLine = true,
        isError = isError,
        placeholder = {
              Text(
                  text = hint,
                  style = MaterialTheme.typography.body1
              )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyBoardType
        ),
        onValueChange = {
            if (it.length <= maxLength) {
                onValueChange(it)
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .semantics {
                this.testTag = Constants.Test.Tag.TEXT_FIELD_STANDARD
            }
    )
}