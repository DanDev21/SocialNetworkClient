package com.dan.socialnetwork.core.domain.state

import androidx.annotation.StringRes
import com.dan.socialnetwork.R

data class StandardTextFieldState(
    val text: String = "",
    @StringRes val stringInt: Int = R.string.empty,
)
