package com.dan.socialnetwork.presentation.util.compose.navigation

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dan.socialnetwork.R
import com.dan.socialnetwork.presentation.util.Screen

@Composable
fun BottomNavigationView(
    modifier: Modifier = Modifier,
    navController: NavController,
    visible: Boolean = true,
    items: List<BottomNavigationItem> = defaultItems
) {
    if (visible) {
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
                        enabled = item.route != Screen.Empty.route,
                        alerts = item.alerts
                    ) {
                        navController.navigate(item.route)
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
        contentDescriptionId = R.string.description_home
    ),
    BottomNavigationItem(
        route = Screen.Chats.route,
        icon = Icons.Outlined.Message,
        contentDescriptionId = R.string.description_chats
    ),
    BottomNavigationItem(
        route = Screen.Empty.route,
        icon = Icons.Default.Delete,
        contentDescriptionId = R.string.empty
    ),
    BottomNavigationItem(
        route = Screen.Activity.route,
        icon = Icons.Outlined.Notifications,
        contentDescriptionId = R.string.description_activity
    ),
    BottomNavigationItem(
        route = Screen.Profile.route,
        icon = Icons.Outlined.Person,
        contentDescriptionId = R.string.description_profile
    ),
)
