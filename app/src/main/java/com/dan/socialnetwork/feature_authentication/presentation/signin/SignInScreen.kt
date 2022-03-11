package com.dan.socialnetwork.feature_authentication.presentation.signin

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dan.socialnetwork.R
import com.dan.socialnetwork.core.presentation.text.Link
import com.dan.socialnetwork.core.presentation.Screen
import com.dan.socialnetwork.core.presentation.Size
import com.dan.socialnetwork.core.presentation.spacer.*
import com.dan.socialnetwork.core.presentation.text_field.PasswordTextField
import com.dan.socialnetwork.core.presentation.text_field.StandardTextField
import com.dan.socialnetwork.extension.navigate
import com.dan.socialnetwork.extension.showSnackBar
import com.dan.socialnetwork.core.data.dto.Result
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SignInScreen(
    navController: NavController,
    scaffoldState: ScaffoldState,
    viewModel: SignInViewModel = hiltViewModel()
) {
    val emailOrUsernameState = viewModel.emailOrUsernameState.value
    val passwordState = viewModel.passwordState.value
    val signingIn = viewModel.signingIn.value

    val context = LocalContext.current

    LaunchedEffect(true) {
        viewModel.loginResultFlow.collectLatest {
            when (it) {
                is Result.Success -> {
                    navController.navigate(Screen.MainFeed.route, true)
                }
                is Result.Error -> {
                    scaffoldState.showSnackBar(it, context)
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = Size.LARGE)
            .padding(bottom = Size.LARGE)
    ) {
        Column(
            modifier = Modifier
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
                text = emailOrUsernameState.text,
                hintStringId = R.string.hint_username_or_email,
                keyBoardType = KeyboardType.Email,
                onValueChange = viewModel::setUsername,
                errorStringInt = emailOrUsernameState.stringInt
            )

            DefaultMediumSpacerV()

            PasswordTextField(
                text = passwordState.text,
                onValueChange = viewModel::setPassword,
                showPassword = passwordState.showPassword,
                onTogglePasswordVisibility = viewModel::setPasswordVisibility,
                errorStringInt = passwordState.stringInt
            )

            DefaultMediumSpacerV()

            Button(
                modifier = Modifier
                    .align(Alignment.End),
                onClick = {
                    if (!signingIn) {
                        viewModel.signIn()
                    }
                }
            ) {
                Text(
                    text = stringResource(R.string.pursue),
                    color = MaterialTheme.colors.onPrimary
                )
            }

            DefaultMediumSpacerV()

            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .alpha(if (signingIn) 1f else 0f)
            )
        }
        Link(
            textStringId = R.string.question_sign_up,
            linkStringId = R.string.sign_up,
            onClick = {
                navController.navigate(Screen.Signup.route)
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}
