package com.dan.socialnetwork.extension

import androidx.navigation.NavController
import com.dan.socialnetwork.core.presentation.navigation.BottomNavigationItem

fun NavController.navigate(route: String, popBackStack: Boolean = false) {
    if (popBackStack) {
        popBackStack()
    }
    navigate(route)
}

fun NavController.navigate(item: BottomNavigationItem) {
    if (currentDestination?.route != item.route) {
        navigate(item.route)
    }
}
