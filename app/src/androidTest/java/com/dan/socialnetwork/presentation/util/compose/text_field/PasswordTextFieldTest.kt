package com.dan.socialnetwork.presentation.util.compose.text_field

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dan.socialnetwork.domain.util.Constants
import com.dan.socialnetwork.presentation.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PasswordTextFieldTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            val text = remember {
                mutableStateOf("")
            }

            MaterialTheme {
                PasswordTextField(
                    text = text.value,
                    maxLength = 5,
                    onValueChange = {
                        text.value = it
                    }
                )
            }
        }
    }

    @Test
    fun testMaxLengthNotExceeded() {
        val string = "12345"
        composeTestRule
            .onNodeWithTag(Constants.Test.Tag.TEXT_FIELD_STANDARD)
            .performTextClearance()

        composeTestRule
            .onNodeWithTag(Constants.Test.Tag.TEXT_FIELD_STANDARD)
            .performTextInput(string)

        composeTestRule
            .onNodeWithTag(Constants.Test.Tag.TEXT_FIELD_STANDARD)
            .performTextInput("6")

        composeTestRule
            .onNodeWithTag(Constants.Test.Tag.TEXT_FIELD_STANDARD)
            .assertTextEquals(string)
    }

    @Test
    fun testButtonTogglePasswordVisibility() {

    }
}