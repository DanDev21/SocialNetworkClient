package com.dan.socialnetwork.presentation.screen.login.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dan.socialnetwork.presentation.screen.login.compose.component.LoginForm
import com.dan.socialnetwork.presentation.screen.login.compose.component.SignUpLink
import com.dan.socialnetwork.presentation.screen.login.viewmodel.LoginViewModel
import com.dan.socialnetwork.presentation.ui.theme.Size_16
import com.dan.socialnetwork.presentation.ui.theme.Size_24
import com.dan.socialnetwork.presentation.util.Screen

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(Size_16)
            .padding(
                bottom = Size_24
            )
    ) {
        LoginForm(
            viewModel = viewModel,
            modifier = Modifier
                .fillMaxSize()
        )
        SignUpLink(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            onClick = {
                navController.navigate(Screen.Signup.route)
            }
        )
    }
}
