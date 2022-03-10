package com.dan.socialnetwork.core.presentation.text_field

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.input.KeyboardType
import com.dan.socialnetwork.R
import com.dan.socialnetwork.util.Test
import com.dan.socialnetwork.core.presentation.text.ErrorText

@Composable
fun StandardTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    @StringRes hintStringId: Int = R.string.empty,
    @StringRes errorStringInt: Int = R.string.empty,
    maxLength: Int = 100,
    keyBoardType: KeyboardType = KeyboardType.Text,
    onValueChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TextField(
            value = text,
            singleLine = true,
            isError = errorStringInt != R.string.empty,
            placeholder = {
                Text(
                    text = stringResource(id = hintStringId),
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
                    this.testTag = Test.Tag.TEXT_FIELD_STANDARD
                }
        )
        if (errorStringInt != R.string.empty) {
            ErrorText(message = stringResource(id = errorStringInt))
        }
    }
}