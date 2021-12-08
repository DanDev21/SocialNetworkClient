package com.dan.socialnetwork.presentation.util.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dan.socialnetwork.presentation.screen.signin.compose.SignInScreen
import com.dan.socialnetwork.presentation.screen.main_feed.compose.MainFeedScreen
import com.dan.socialnetwork.presentation.screen.signup.compose.SignUpScreen
import com.dan.socialnetwork.presentation.screen.splash.SplashScreen
import com.dan.socialnetwork.presentation.util.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screen.Signin.route) {
            SignInScreen(navController)
        }
        composable(Screen.Signup.route) {
            SignUpScreen(navController)
        }
        composable(Screen.MainFeed.route) {
            MainFeedScreen(navController)
        }
    }
}

