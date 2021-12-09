package com.dan.socialnetwork.presentation.util.compose.navigation

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dan.socialnetwork.R
import com.dan.socialnetwork.presentation.util.BottomNavigationItem
import com.dan.socialnetwork.presentation.util.Screen
import com.dan.socialnetwork.presentation.util.extension.navigate

@Composable
fun BottomNavigationView(
    modifier: Modifier = Modifier,
    navController: NavController,
    items: List<BottomNavigationItem> = defaultItems
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    if (defaultVisibilityRule(navBackStackEntry)) {
        BottomAppBar(
            backgroundColor = MaterialTheme.colors.surface,
            cutoutShape = CircleShape,
            elevation = 5.dp,
            modifier = modifier,
        ) {
            BottomNavigation {
                items.forEach { item ->
                    NotifiableBottomNavigationItem(
                        icon = item.icon,
                        selected = item.route == navController.currentDestination?.route,
                        contentDescription = stringResource(item.contentDescriptionId),
                        alerts = item.alerts,
                        enabled = true
                    ) {
                        navController.navigate(item)
                    }
                }
            }
        }
    }
}

private val defaultItems = listOf(
    BottomNavigationItem(
        route = Screen.MainFeed.route,
        icon = Icons.Outlined.Home,
        contentDescriptionId = R.string.description_home,
        alerts = 12
    ),
    BottomNavigationItem(
        route = Screen.Chats.route,
        icon = Icons.Outlined.Message,
        contentDescriptionId = R.string.description_chats
    ),
    BottomNavigationItem(
        route = Screen.Activity.route,
        icon = Icons.Outlined.Notifications,
        contentDescriptionId = R.string.description_activity,
        alerts = 150
    ),
    BottomNavigationItem(
        route = Screen.Profile.route,
        icon = Icons.Outlined.Person,
        contentDescriptionId = R.string.description_profile
    ),
)

private fun defaultVisibilityRule(currentBackStackEntry: NavBackStackEntry?): Boolean =
    currentBackStackEntry?.destination?.route in listOf(
        Screen.MainFeed.route,
        Screen.Chats.route,
        Screen.Activity.route,
        Screen.Profile.route
    )

