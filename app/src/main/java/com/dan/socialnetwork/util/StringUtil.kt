package com.dan.socialnetwork.util

import android.text.TextUtils
import android.util.Patterns
import com.dan.socialnetwork.util.Length.Max

object StringUtil {

    fun isNotValidEmail(email: String) = !isValidEmail(email)

    fun isValidEmail(email: String) =
        !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun format(string: String) = StringUtilBuilder(string)

    class StringUtilBuilder(private var string: String) {

        fun asUsername(): StringUtilBuilder {
            string = "@$string"
            if (Max.USERNAME < string.length) {
                string = string.subSequence(0..Max.USERNAME).toString() + "..."
            }
            return this
        }

        fun get() = this.string
    }
}