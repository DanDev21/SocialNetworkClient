package com.dan.socialnetwork.presentation.util.compose.text_field

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = stringResource(id = R.string.hint_password),
    maxLength: Int = 20,
    isError: Boolean = false,
    keyBoardType: KeyboardType = KeyboardType.Password,
    onValueChange: (String) -> Unit
) {
    val displayPassword = remember {
        mutableStateOf(false)
    }
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
        visualTransformation = getVisualTransformation(displayPassword.value),
        trailingIcon = {
                       IconButton(
                           modifier = Modifier
                               .semantics {
                                   this.testTag = Constants.Test.Tag.BUTTON_TOGGLE_PASSWORD_VISIBILITY
                               },
                           onClick = {
                               displayPassword.value = !displayPassword.value
                           }
                       ) {
                           Icon(
                               imageVector = getIconVector(displayPassword.value),
                               tint = MaterialTheme.colors.primary,
                               contentDescription = stringResource(
                                   id = getIconDescription(displayPassword.value)
                               )
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
                this.testTag = Constants.Test.Tag.TEXT_FIELD_PASSWORD
            }
    )
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