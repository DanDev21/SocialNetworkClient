package com.dan.socialnetwork.presentation.screen.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.dan.socialnetwork.R
import com.dan.socialnetwork.presentation.ui.theme.Size_24
import com.dan.socialnetwork.presentation.ui.theme.Size_8
import com.dan.socialnetwork.presentation.util.compose.text_field.StandardTextField

@Composable
fun LoginScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = Size_24
            ),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.login),
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onBackground,
        )
        Spacer(modifier = Modifier.height(Size_8))
    }
}
