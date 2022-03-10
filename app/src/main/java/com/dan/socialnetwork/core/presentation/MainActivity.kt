package com.dan.socialnetwork.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dan.socialnetwork.core.presentation.theme.SocialNetworkTheme
import com.dan.socialnetwork.core.presentation.scaffold.MainScaffold
import com.dan.socialnetwork.core.presentation.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContent {
            SocialNetworkTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    val scaffoldState = rememberScaffoldState()
                    val navController = rememberNavController()
                    val navBackStackEntry by navController
                        .currentBackStackEntryAsState()

                    MainScaffold(
                        state = scaffoldState,
                        navController = navController,
                        showBottomNavigationView = this.showBottomNavigationView(navBackStackEntry),
                        onFabClick = {
                            navController.navigate(Screen.CreatePost.route)
                        },
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Navigation(navController, scaffoldState)
                    }
                }
            }
        }
    }

    private fun showBottomNavigationView(currentBackStackEntry: NavBackStackEntry?): Boolean {
        return currentBackStackEntry?.destination?.route in
                listOf(
                    Screen.MainFeed.route,
                    Screen.Chats.route,
                    Screen.Activity.route,
                    Screen.Profile.route
                )
    }
}
