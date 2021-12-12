package com.dan.socialnetwork.presentation.util.compose.button

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import com.dan.socialnetwork.presentation.util.Constants

@Composable
fun ToggleButton(
    defaultState: Boolean,
    defaultIcon: ImageVector,
    activeIcon: ImageVector,
    defaultDescription: String,
    activeDescription: String,
    iconTint: Color = MaterialTheme.colors.primary,
    onClick: (Boolean) -> Unit
) {
    IconButton(
        onClick = {
            onClick(!defaultState)
        },
        modifier = Modifier
            .semantics {
                this.testTag = Constants.Test.Tag.BUTTON_TOGGLE_PASSWORD_VISIBILITY
            }
    ) {
        Icon(
            imageVector = if (defaultState) defaultIcon else activeIcon,
            contentDescription = if (defaultState) defaultDescription else activeDescription,
            tint = iconTint
        )
    }
}
