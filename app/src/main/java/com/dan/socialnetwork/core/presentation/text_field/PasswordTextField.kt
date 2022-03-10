package com.dan.socialnetwork.core.presentation.text_field

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.dan.socialnetwork.R
import com.dan.socialnetwork.util.Test
import com.dan.socialnetwork.core.presentation.button.ToggleButton
import com.dan.socialnetwork.core.presentation.text.ErrorText

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    maxLength: Int = 20,
    @StringRes hintStringId: Int = R.string.hint_password,
    @StringRes errorStringInt: Int = R.string.empty,
    keyBoardType: KeyboardType = KeyboardType.Password,
    showPassword: Boolean = false,
    letUserToggleVisibility: Boolean = true,
    onTogglePasswordVisibility: (Boolean) -> Unit = {},
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
            visualTransformation = getVisualTransformation(showPassword),
            trailingIcon = {
                if (letUserToggleVisibility) {
                    ToggleButton(
                        defaultState = showPassword,
                        defaultIcon = Icons.Filled.VisibilityOff,
                        activeIcon = Icons.Filled.Visibility,
                        defaultDescription = stringResource(R.string.description_password_invisible),
                        activeDescription = stringResource(R.string.description_password_visible),
                        onClick = onTogglePasswordVisibility
                    )
                }
            },
            onValueChange = {
                if (it.length <= maxLength) {
                    onValueChange(it)
                }
            },
            modifier = modifier
                .fillMaxWidth()
                .semantics {
                    this.testTag = Test.Tag.TEXT_FIELD_PASSWORD
                }
        )
        if (errorStringInt != R.string.empty) {
            ErrorText(message = stringResource(id = errorStringInt))
        }
    }

}

private fun getVisualTransformation(visible: Boolean): VisualTransformation =
    if (visible)    VisualTransformation.None
    else            PasswordVisualTransformation()