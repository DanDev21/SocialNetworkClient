package com.dan.socialnetwork.presentation.util

object StringUtil {

    fun format(string: String) = StringUtilBuilder(string)

    class StringUtilBuilder(
        private var string: String
    ) {
        fun asUsername(): StringUtilBuilder {
            string = "@$string"
            if (Constants.Max.USERNAME_LENGTH < string.length) {
                string = string
                    .subSequence(0..Constants.Max.USERNAME_LENGTH)
                    .toString() + "..."
            }
            return this
        }

        fun get() = this.string
    }
}