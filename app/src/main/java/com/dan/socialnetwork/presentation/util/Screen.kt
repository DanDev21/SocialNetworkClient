package com.dan.socialnetwork.presentation.util

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Signup : Screen("signup")
    object MainFeed : Screen("main")
    object PostDetails : Screen("post_details")
    object Users : Screen("users")
    object Chats : Screen("chats")
    object Chat : Screen("chat")
    object Profile : Screen("profile")
    object EditProfile : Screen("edit_profile")
    object Activity : Screen("activity")
    object Search : Screen("search")
    object CreatePost : Screen("create_post")
}
