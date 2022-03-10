package com.dan.socialnetwork.core.presentation.navigation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dan.socialnetwork.util.Time
import com.dan.socialnetwork.core.presentation.Color.Hint.Gray
import com.dan.socialnetwork.core.presentation.Size
import java.lang.IllegalArgumentException
import kotlin.jvm.Throws

@Composable
@Throws(IllegalArgumentException::class)
fun RowScope.NotifiableBottomNavigationItem(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    selected: Boolean = false,
    icon: ImageVector,
    iconSize: Dp = 30.dp,
    contentDescription: String,
    selectedColor: Color = MaterialTheme.colors.primary,
    unselectedColor: Color = Gray,
    alerts: Int = 0,
    onClick: () -> Unit
) {
    if (alerts < 0) {
        throw IllegalArgumentException("illegal state: alerts < 0!")
    }

    val bottomLineLength = animateFloatAsState(
        targetValue = if (selected) 1f else 0f,
        animationSpec = tween(
            durationMillis = Time.BOTTOM_NAVIGATION_ITEM_LINE_ANIMATION
        )
    )

    BottomNavigationItem(
        enabled = enabled,
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        icon = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .drawBehind {
                        if (bottomLineLength.value > 0) {
                            drawLine(
                                color = selectedColor,
                                strokeWidth = 5.dp.toPx(),
                                cap = StrokeCap.Round,
                                start = Offset(
                                    x = size.width / 2f - bottomLineLength.value * 15.dp.toPx(),
                                    y = size.height
                                ),
                                end = Offset(
                                    x = size.width / 2f + bottomLineLength.value * 15.dp.toPx(),
                                    y = size.height
                                ),
                            )
                        }
                    }
                    .padding(Size.EXTRA_SMALL)
            ) {
                if (enabled) {
                    Icon(
                        imageVector = icon,
                        contentDescription = contentDescription,
                        tint = if (selected) selectedColor else unselectedColor,
                        modifier = Modifier
                            .size(iconSize)
                            .align(Alignment.Center)
                    )
                }

                if (alerts > 0) {
                    Text(
                        text = getNotificationText(alerts),
                        color = MaterialTheme.colors.onPrimary,
                        fontSize = Size.Text.EXTRA_SMALL,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .offset(15.dp)
                            .size(15.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colors.primary)
                    )
                }
            }
        }
    )
}

private fun getNotificationText(alerts: Int): String =
    if (alerts > 99) "99+" else alerts.toString()
