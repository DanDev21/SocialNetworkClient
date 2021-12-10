package com.dan.socialnetwork.presentation.screen.signup.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dan.socialnetwork.R
import com.dan.socialnetwork.presentation.util.compose.text.Link
import com.dan.socialnetwork.presentation.screen.signup.viewmodel.SignUpViewModel
import com.dan.socialnetwork.presentation.ui.theme.Size_16
import com.dan.socialnetwork.presentation.ui.theme.Size_24
import com.dan.socialnetwork.presentation.util.Screen
import com.dan.socialnetwork.presentation.util.compose.text_field.PasswordTextField
import com.dan.socialnetwork.presentation.util.compose.text_field.StandardTextField

@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(Size_24)
            .padding(
                bottom = Size_24
            )
    ) {
        Column(
            modifier= Modifier
                .fillMaxSize()
                .padding(Size_24),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.sign_up),
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onBackground,
            )

            Spacer(modifier = Modifier.height(Size_16))

            StandardTextField(
                text = viewModel.email.value,
                hint = stringResource(R.string.hint_email),
                onValueChange = viewModel::setEmail,
                errorMessage = viewModel.emailErrorMessage.value
            )

            Spacer(modifier = Modifier.height(Size_16))

            StandardTextField(
                text = viewModel.username.value,
                hint = stringResource(R.string.hint_username),
                onValueChange = viewModel::setUsername,
                errorMessage = viewModel.usernameErrorMessage.value
            )

            Spacer(modifier = Modifier.height(Size_16))

            PasswordTextField(
                text = viewModel.password.value,
                onValueChange = viewModel::setPassword,
                showPassword = viewModel.showPassword.value,
                onTogglePasswordVisibility = viewModel::setShowPassword,
                errorMessage = viewModel.passwordErrorMessage.value
            )

            Spacer(modifier = Modifier.height(Size_16))

            PasswordTextField(
                text = viewModel.passwordConfirmation.value,
                hint = stringResource(R.string.hint_repeat_password),
                onValueChange = viewModel::setPasswordConfirmation,
                showPassword = viewModel.showPassword.value,
                letUserToggleVisibility = false,
                errorMessage = viewModel.passwordErrorMessage.value
            )

            Spacer(modifier = Modifier.height(Size_16))

            Button(
                modifier = Modifier
                    .align(Alignment.End),
                onClick = {

                }
            ) {
                Text(
                    text = stringResource(R.string.pursue),
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
        Link(
            text = stringResource(R.string.question_sign_in),
            link = stringResource(R.string.sign_in),
            onClick = {
                navController.navigate(Screen.SignIn.route)
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}
