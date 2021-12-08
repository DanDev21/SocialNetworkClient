package com.dan.socialnetwork.presentation.screen.signup

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SignupViewModel @Inject constructor() : ViewModel() {

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _username = mutableStateOf("")
    val username: State<String> = _username

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _passwordConfirmation = mutableStateOf("")
    val passwordConfirmation: State<String> = _passwordConfirmation

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    private val _emailErrorMessage = mutableStateOf("")
    val emailErrorMessage: State<String> = _emailErrorMessage

    private val _usernameErrorMessage = mutableStateOf("")
    val usernameErrorMessage: State<String> = _usernameErrorMessage

    private val _passwordErrorMessage = mutableStateOf("")
    val passwordErrorMessage: State<String> = _passwordErrorMessage

    fun setEmail(email: String) {
        this._email.value = email
    }

    fun setUsername(username: String) {
        this._username.value = username
    }

    fun setPassword(password: String) {
        this._password.value = password
    }

    fun setPasswordConfirmation(passwordConfirmation: String) {
        this._passwordConfirmation.value = passwordConfirmation
    }

    fun setShowPassword(showPassword: Boolean) {
        this._showPassword.value = showPassword
    }

    fun setEmailErrorMessage(message: String) {
        this._emailErrorMessage.value = message
    }

    fun setUsernameErrorMessage(message: String) {
        this._usernameErrorMessage.value = message
    }

    fun setPasswordErrorMessage(message: String) {
        this._usernameErrorMessage.value = message
    }
}