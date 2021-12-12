package com.dan.socialnetwork.presentation.screen.signin.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dan.socialnetwork.R
import com.dan.socialnetwork.presentation.util.compose.text.Link
import com.dan.socialnetwork.presentation.screen.signin.viewmodel.SignInViewModel
import com.dan.socialnetwork.presentation.util.Constants
import com.dan.socialnetwork.presentation.util.Screen
import com.dan.socialnetwork.presentation.util.compose.spacer.vertical.DefaultMediumSpacerV
import com.dan.socialnetwork.presentation.util.compose.text_field.PasswordTextField
import com.dan.socialnetwork.presentation.util.compose.text_field.StandardTextField
import com.dan.socialnetwork.presentation.util.extension.navigate

@Composable
fun SignInScreen(
    navController: NavController,
    viewModel: SignInViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = Constants.Size.LARGE)
            .padding(
                bottom = Constants.Size.LARGE
            )
    ) {
        Column(
            modifier=  Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.sign_in),
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onBackground,
            )

            DefaultMediumSpacerV()

            StandardTextField(
                text = viewModel.username.value,
                hint = stringResource(R.string.hint_username_or_email),
                keyBoardType = KeyboardType.Email,
                onValueChange = viewModel::setUsername,
                errorMessage = viewModel.usernameErrorMessage.value
            )

            DefaultMediumSpacerV()

            PasswordTextField(
                text = viewModel.password.value,
                onValueChange = viewModel::setPassword,
                showPassword = viewModel.showPassword.value,
                onTogglePasswordVisibility = viewModel::setShowPassword,
                errorMessage = viewModel.passwordErrorMessage.value
            )

            DefaultMediumSpacerV()

            Button(
                modifier = Modifier
                    .align(Alignment.End),
                onClick = {
                    navController.navigate(Screen.MainFeed.route, true)
                }
            ) {
                Text(
                    text = stringResource(R.string.pursue),
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
        Link(
            text = stringResource(R.string.question_sign_up),
            link = stringResource(R.string.sign_up),
            onClick = {
                navController.navigate(Screen.Signup.route)
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}
