package com.dan.socialnetwork.util

import java.text.SimpleDateFormat
import java.util.*

object DateFormatter {

    fun format(timestamp: Long, pattern: String): String =
        SimpleDateFormat(pattern, Locale.getDefault())
            .format(timestamp)
}