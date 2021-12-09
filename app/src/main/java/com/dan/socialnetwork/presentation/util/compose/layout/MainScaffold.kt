package com.dan.socialnetwork.presentation.util.compose.layout

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.dan.socialnetwork.presentation.util.compose.navigation.BottomNavigationView

@Composable
fun MainScaffold(
    modifier: Modifier = Modifier,
    navController: NavController,
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            BottomNavigationView(
                navController = navController,
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) {
        content()
    }
}
