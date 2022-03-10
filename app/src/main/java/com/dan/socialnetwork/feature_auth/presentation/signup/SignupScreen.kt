package com.dan.socialnetwork.feature_auth.presentation.signup

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dan.socialnetwork.R
import com.dan.socialnetwork.core.presentation.Screen
import com.dan.socialnetwork.core.presentation.Size
import com.dan.socialnetwork.core.presentation.spacer.DefaultMediumSpacerV
import com.dan.socialnetwork.core.presentation.text.Link
import com.dan.socialnetwork.core.presentation.text_field.PasswordTextField
import com.dan.socialnetwork.core.presentation.text_field.StandardTextField
import com.dan.socialnetwork.extension.showSnackBar
import com.dan.socialnetwork.util.Result
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SignUpScreen(
    navController: NavController,
    scaffoldState: ScaffoldState,
    viewModel: SignupViewModel = hiltViewModel()
) {
    val signingUp = viewModel.signingUpState.value
    val emailState = viewModel.emailState.value
    val usernameState = viewModel.usernameState.value
    val passwordState = viewModel.passwordState.value
    val passwordConfirmationState = viewModel.passwordConfirmationState.value

    val context = LocalContext.current

    LaunchedEffect(true) {
        viewModel.signupResultFlow.collectLatest {
            when (it) {
                is Result.Success -> {
                    navController.popBackStack()
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
            modifier= Modifier
                .fillMaxSize()
                .padding(all = Size.LARGE),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.sign_up),
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onBackground,
            )

            DefaultMediumSpacerV()

            StandardTextField(
                text = emailState.text,
                hintStringId = R.string.hint_email,
                onValueChange = viewModel::setEmail,
                keyBoardType = KeyboardType.Email,
                errorStringInt = emailState.stringInt
            )

            DefaultMediumSpacerV()

            StandardTextField(
                text = usernameState.text,
                hintStringId = R.string.hint_username,
                onValueChange = viewModel::setUsername,
                errorStringInt = usernameState.stringInt
            )

            DefaultMediumSpacerV()

            PasswordTextField(
                text = passwordState.text,
                onValueChange = viewModel::setPassword,
                showPassword = viewModel.showPasswordState.value,
                onTogglePasswordVisibility = viewModel::setPasswordVisibility,
                errorStringInt = passwordState.stringInt,
            )

            DefaultMediumSpacerV()

            PasswordTextField(
                text = passwordConfirmationState.text,
                hintStringId = R.string.hint_repeat_password,
                errorStringInt = passwordConfirmationState.stringInt,
                onValueChange = viewModel::setPasswordConfirmation,
                showPassword = viewModel.showPasswordState.value,
                letUserToggleVisibility = false,
            )

            DefaultMediumSpacerV()

            Button(
                modifier = Modifier
                    .align(Alignment.End),
                onClick = {
                    if (!signingUp) {
                        viewModel.signup()
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
                    .align(CenterHorizontally)
                    .alpha(if (signingUp) 1f else 0f),
            )
        }
        Link(
            textStringId = R.string.question_sign_in,
            linkStringId = R.string.sign_in,
            onClick = {
                navController.navigate(Screen.SignIn.route)
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}
