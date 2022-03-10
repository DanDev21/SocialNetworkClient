package com.dan.socialnetwork.core.presentation

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object Size {

    val EXTRA_SMALL = 5.dp
    val SMALL = 8.dp
    val MEDIUM = 16.dp
    val LARGE = 24.dp

    object Image {
        val DEFAULT = 30.dp
        val PROFILE_PICTURE = 64.dp
        val PROFILE_PICTURE_EXTRA_SMALL = 24.dp
        val PROFILE_PICTURE_LARGE = 144.dp
    }

    object Text {
        val EXTRA_SMALL = 10.sp
        val SMALL = 12.sp
        val NORMAL = 14.sp
        val MEDIUM = 16.sp
        val LARGE = 24.sp
    }
}

object Width {

    object Border {
        val PROFILE_PICTURE = (1.5).dp
    }
}

object Color {

    object Background {
        val Gray = Color(0xFF202020)
    }

    object Surface {
        val Gray = Color(0xFF2D2D2D)
    }

    object On {

        object Background {
            val Gray = Color(0xFFEEEEEE)
            val Red = Color.Red
        }

        object Surface {
            val Gray = Color(0xFF404040)
        }
    }

    object Hint {
        val Gray = Color(0xFF6D6D6D)
    }

    object Text {
        val Gray = Color(0xFFA6A6A6)
    }

    object Accent {
        val Blue = Color(0xFF0062FF)
        val Green = Color(0xFF08FF04)
    }
}