package com.dan.socialnetwork.presentation.util.extension

import androidx.navigation.NavController

fun NavController.navigate(route: String, shouldPop: Boolean = false) {
    if (shouldPop) {
        this.popBackStack()
    }
    this.navigate(route)
}
