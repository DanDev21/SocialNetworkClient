package com.dan.socialnetwork.presentation.util

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object Constants {

    object Time {
        const val SPLASH_SCREEN = 300L
        const val SPLASH_SCREEN_ANIMATION = 350
        const val BOTTOM_NAVIGATION_ITEM_LINE_ANIMATION = 250
    }

    object Max {
        const val DESCRIPTION_LINES = 3
        const val USERNAME_LENGTH = 9
    }

    object Test {

        object Tag {
            const val TEXT_FIELD_STANDARD = "text_field_standard"
            const val TEXT_FIELD_PASSWORD = "text_field_password"
            const val BUTTON_TOGGLE_PASSWORD_VISIBILITY = "button_toggle_password_visibility"
        }
    }

    object Size {

        val EXTRA_SMALL = 5.dp
        val SMALL = 8.dp
        val MEDIUM = 16.dp
        val LARGE = 24.dp

        object Image {
            val DEFAULT = 30.dp
            val PROFILE_PICTURE = 64.dp
            val PROFILE_PICTURE_EXTRA_SMALL = 24.dp
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
}