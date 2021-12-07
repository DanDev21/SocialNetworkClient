package com.dan.socialnetwork.presentation.screen.login.compose.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.dan.socialnetwork.R
import com.dan.socialnetwork.presentation.screen.login.viewmodel.LoginViewModel
import com.dan.socialnetwork.presentation.ui.theme.Size_24
import com.dan.socialnetwork.presentation.ui.theme.Size_8
import com.dan.socialnetwork.presentation.util.compose.text_field.PasswordTextField
import com.dan.socialnetwork.presentation.util.compose.text_field.StandardTextField

@Composable
fun LoginForm(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.login),
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onBackground,
        )
        Spacer(modifier = Modifier.height(Size_8))
        StandardTextField(
            text = viewModel.username.value,
            hint = stringResource(id = R.string.hint_username),
            onValueChange = viewModel::setUsername
        )
        Spacer(modifier = Modifier.height(Size_8))
        PasswordTextField(
            text = viewModel.password.value,
            onValueChange = viewModel::setPassword
        )
    }
}
