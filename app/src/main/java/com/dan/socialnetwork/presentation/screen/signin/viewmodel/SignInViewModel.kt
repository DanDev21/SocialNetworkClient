package com.dan.socialnetwork.presentation.screen.signin.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor() : ViewModel() {

    private val _username = mutableStateOf("")
    val username: State<String> = _username

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    private val _usernameError = mutableStateOf("")
    val usernameErrorMessage: State<String> = _usernameError

    private val _passwordError = mutableStateOf("")
    val passwordErrorMessage: State<String> = _passwordError

    fun setUsername(username: String) {
        this._username.value = username
    }

    fun setPassword(password: String) {
        this._password.value = password
    }

    fun setShowPassword(showPassword: Boolean) {
        this._showPassword.value = showPassword
    }

    fun setUsernameErrorMessage(message: String) {
        this._usernameError.value = message
    }

    fun setPasswordErrorMessage(message: String) {
        this._usernameError.value = message
    }
}