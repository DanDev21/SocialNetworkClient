package com.dan.socialnetwork.presentation.util.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dan.socialnetwork.presentation.screen.activity.compose.ActivityScreen
import com.dan.socialnetwork.presentation.screen.chats.compose.ChatsScreen
import com.dan.socialnetwork.presentation.screen.signin.compose.SignInScreen
import com.dan.socialnetwork.presentation.screen.main_feed.compose.MainFeedScreen
import com.dan.socialnetwork.presentation.screen.profile.compose.ProfileScreen
import com.dan.socialnetwork.presentation.screen.signup.compose.SignUpScreen
import com.dan.socialnetwork.presentation.screen.splash.SplashScreen
import com.dan.socialnetwork.presentation.util.Screen

@Composable
fun Navigation(
    navController: NavHostController
) {
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
        composable(Screen.Chats.route) {
            ChatsScreen(navController)
        }
        composable(Screen.Activity.route) {
            ActivityScreen(navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
    }
}

