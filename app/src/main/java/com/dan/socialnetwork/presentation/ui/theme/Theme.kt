package com.dan.socialnetwork.presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Blue_acct,
    onPrimary = Gray_bg,
    background = Gray_bg,
    onBackground = Gray_on_bg,
    surface = Gray_sfc,
    onSurface = Gray_on_sfc
)

@Composable
fun SocialNetworkTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}