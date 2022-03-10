package com.dan.socialnetwork.core.presentation.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.dan.socialnetwork.core.presentation.Color

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

private val DarkColorPalette = darkColors(
    primary = Color.Accent.Blue,
    onPrimary = Color.Background.Gray,
    background = Color.Background.Gray,
    onBackground = Color.On.Background.Gray,
    surface = Color.Surface.Gray,
    onSurface = Color.On.Surface.Gray,
)

private val Shapes = Shapes(
    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(25.dp),
    large = RoundedCornerShape(50.dp)
)