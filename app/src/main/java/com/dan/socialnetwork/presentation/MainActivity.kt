package com.dan.socialnetwork.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.dan.socialnetwork.presentation.ui.theme.SocialNetworkTheme
import com.dan.socialnetwork.presentation.util.compose.layout.MainScaffold
import com.dan.socialnetwork.presentation.util.compose.navigation.Navigation
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
                    val navController = rememberNavController()
                    MainScaffold(
                        navController = navController,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Navigation(navController)
                    }
                }
            }
        }
    }
}
