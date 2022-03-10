package com.dan.socialnetwork.util

import androidx.annotation.StringRes
import com.dan.socialnetwork.R

open class AppException(@StringRes open val stringInt: Int = R.string.empty) : Exception()