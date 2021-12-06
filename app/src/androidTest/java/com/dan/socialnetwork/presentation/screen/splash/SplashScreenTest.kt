package com.dan.socialnetwork.presentation.screen.splash

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dan.socialnetwork.domain.util.Constants
import com.dan.socialnetwork.presentation.MainActivity
import com.dan.socialnetwork.presentation.ui.theme.SocialNetworkTheme
import com.dan.socialnetwork.presentation.util.Screen
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SplashScreenTest {

    @get:Rule
    val rule = createAndroidComposeRule<MainActivity>()

    // mocks
    @RelaxedMockK
    lateinit var navController: NavController

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    @ExperimentalCoroutinesApi
    fun testDisplaysAndDisappears() = runBlockingTest {
        rule.setContent {
            SocialNetworkTheme {
                SplashScreen(navController)
            }
        }

        // assert it displays the logo
        rule
            .onNodeWithContentDescription(Constants.DESCRIPTION_IMAGE_LOGO)
            .assertExists()

        verify {
            navController.navigate(Screen.Login.route) {
                this.popUpTo(Screen.Login.route) {
                    this.inclusive = true
                }
            }
        }
    }
}