package com.dan.socialnetwork.presentation.util.compose.text_field

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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.dan.socialnetwork.R
import com.dan.socialnetwork.domain.util.Constants
import com.dan.socialnetwork.presentation.util.compose.text.ErrorText

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = stringResource(id = R.string.hint_password),
    maxLength: Int = 20,
    errorMessage: String = "",
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
            isError = errorMessage != "",
            placeholder = {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.body1
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = keyBoardType
            ),
            visualTransformation = getVisualTransformation(showPassword),
            trailingIcon = {
                if (letUserToggleVisibility) {
                    IconButton(
                        modifier = Modifier
                            .semantics {
                                this.testTag = Constants.Test.Tag.BUTTON_TOGGLE_PASSWORD_VISIBILITY
                            },
                        onClick = {
                            onTogglePasswordVisibility(!showPassword)
                        }
                    ) {
                        Icon(
                            imageVector = getIconVector(showPassword),
                            tint = MaterialTheme.colors.primary,
                            contentDescription = stringResource(
                                id = getIconDescription(showPassword)
                            )
                        )
                    }
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
                    this.testTag = Constants.Test.Tag.TEXT_FIELD_PASSWORD
                }
        )
        if (errorMessage.isNotEmpty()) {
            ErrorText(message = errorMessage)
        }
    }

}

private fun getIconVector(visible: Boolean): ImageVector =
    if (visible)    Icons.Filled.VisibilityOff
    else            Icons.Filled.Visibility

@StringRes
private fun getIconDescription(visible: Boolean): Int =
    if (visible)    R.string.description_password_visible
    else            R.string.description_password_invisible

private fun getVisualTransformation(visible: Boolean): VisualTransformation =
    if (visible)    VisualTransformation.None
    else            PasswordVisualTransformation()