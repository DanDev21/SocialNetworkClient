package com.dan.socialnetwork.feature_authentication.presentation.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dan.socialnetwork.R
import com.dan.socialnetwork.util.Time
import com.dan.socialnetwork.core.presentation.Screen
import com.dan.socialnetwork.extension.navigate
import com.dan.socialnetwork.core.data.dto.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withContext

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashScreenViewModel = hiltViewModel(),
    dispatcher: CoroutineDispatcher = Dispatchers.Main,
) {
    val scale = remember {
        Animatable(0f)
    }
    val overshootInterpolator = remember {
        OvershootInterpolator(2f)
    }

    LaunchedEffect(true) {
        viewModel.authenticationResultFlow.collectLatest {
            val route = when (it) {
                is Result.Success -> {
                    Screen.MainFeed.route
                }
                else -> {
                    Screen.SignIn.route
                }
            }
            navController.navigate(route, true)
        }
    }

    LaunchedEffect(true) {
        withContext(dispatcher) {
            scale.animateTo(
                targetValue = 1f,
                animationSpec = tween(
                    durationMillis = Time.SPLASH_SCREEN_ANIMATION,
                    easing = {
                        overshootInterpolator.getInterpolation(it)
                    }
                )
            )
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = stringResource(R.string.description_logo),
            modifier = Modifier
                .scale(scale.value)
        )
    }
}
