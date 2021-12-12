package com.dan.socialnetwork.domain.util

import com.dan.socialnetwork.presentation.util.Constants

object StringUtil {

    fun crop(string: String): String =
        if (Constants.Max.USERNAME_LENGTH < string.length) {
            string.subSequence(0..Constants.Max.USERNAME_LENGTH)
                .toString() + "..."
        } else {
            string
        }
}