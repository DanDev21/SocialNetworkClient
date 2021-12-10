package com.dan.socialnetwork.presentation.util.compose.layout

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.dan.socialnetwork.R
import com.dan.socialnetwork.presentation.util.compose.navigation.BottomNavigationView

@Composable
fun MainScaffold(
    modifier: Modifier = Modifier,
    navController: NavController,
    showBottomNavigationView: Boolean = true,
    onFabClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomNavigationView(
                navController = navController,
                visible = showBottomNavigationView,
                modifier = Modifier
                    .fillMaxWidth()
            )
        },
        floatingActionButton = {
            if (showBottomNavigationView) {
                FloatingActionButton(
                    backgroundColor = MaterialTheme.colors.primary,
                    onClick = onFabClick
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = stringResource(R.string.description_create_post)
                    )
                }
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        modifier = modifier,
    ) {
        content()
    }
}
