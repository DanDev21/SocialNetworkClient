package com.dan.socialnetwork.presentation.util.extension

import androidx.navigation.NavController
import com.dan.socialnetwork.presentation.util.BottomNavigationItem

fun NavController.navigate(route: String, shouldPop: Boolean = false) {
    if (shouldPop) {
        this.popBackStack()
    }
    this.navigate(route)
}

fun NavController.navigate(item: BottomNavigationItem) {
    if (this.currentDestination?.route != item.route) {
        this.navigate(item.route)
    }
}
