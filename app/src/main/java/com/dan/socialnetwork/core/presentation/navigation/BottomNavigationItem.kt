package com.dan.socialnetwork.core.presentation.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val route: String,
    val icon: ImageVector,
    @StringRes val contentDescriptionId: Int,
    val alerts: Int = 0
)