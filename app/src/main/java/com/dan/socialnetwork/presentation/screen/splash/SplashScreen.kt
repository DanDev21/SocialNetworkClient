package com.dan.socialnetwork.presentation.screen.splash

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
import androidx.navigation.NavController
import com.dan.socialnetwork.R
import com.dan.socialnetwork.domain.util.Constants
import com.dan.socialnetwork.presentation.util.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val scale = remember {
            Animatable(0f)
        }
        val overshootInterpolator = remember {
            OvershootInterpolator(2f)
        }
        LaunchedEffect(true) {
            scale.animateTo(
                targetValue = 1f,
                animationSpec = tween(
                    durationMillis = 500,
                    easing = {
                        overshootInterpolator.getInterpolation(it)
                    }
                )
            )
            delay(Constants.DURATION_SPLASH_SCREEN)
            navController.navigate(Screen.Login.route) {
                this.popUpTo(Screen.Login.route) {
                    this.inclusive = true
                }
            }
        }
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = Constants.DESCRIPTION_IMAGE_LOGO,
            modifier = Modifier
                .scale(scale.value)
        )
    }
}