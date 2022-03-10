package com.dan.socialnetwork.feature_auth.presentation.signin

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dan.socialnetwork.R
import com.dan.socialnetwork.core.data.dto.response.SingletonResponse
import com.dan.socialnetwork.core.domain.state.PasswordTextFieldState
import com.dan.socialnetwork.core.domain.state.StandardTextFieldState
import com.dan.socialnetwork.feature_auth.data.validation.SignInException
import com.dan.socialnetwork.feature_auth.data.validation.SignInException.EmailOrUsernameException
import com.dan.socialnetwork.feature_auth.data.validation.SignInException.PasswordException
import com.dan.socialnetwork.feature_auth.use_case.SignInUseCase
import com.dan.socialnetwork.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
) : ViewModel() {

    private val _emailOrUsernameState = mutableStateOf(StandardTextFieldState())
    val emailOrUsernameState: State<StandardTextFieldState> = _emailOrUsernameState

    private val _passwordState = mutableStateOf(PasswordTextFieldState())
    val passwordState: State<PasswordTextFieldState> = _passwordState

    private val _signingInState = mutableStateOf(false)
    val signingIn: State<Boolean> = _signingInState

    private val _loginResultFlow = MutableSharedFlow<Result<SingletonResponse<String>>>()
    val loginResultFlow = _loginResultFlow.asSharedFlow()

    fun signIn() = viewModelScope.launch {
        try {
            resetStatesErrors()
            _signingInState.value = true

            _loginResultFlow.emit(
                signInUseCase(
                    emailOrUsername = _emailOrUsernameState.value.text.trim(),
                    password = _passwordState.value.text.trim(),
                )
            )
        } catch (e: SignInException) {
            handleUserInputException(e)
        } finally {
            _signingInState.value = false
        }
    }

    private fun resetStatesErrors() {
        setEmailOrUsernameError(R.string.empty)
        setPasswordError(R.string.empty)
    }

    private fun handleUserInputException(e: SignInException) {
        when (e) {
            is EmailOrUsernameException -> setEmailOrUsernameError(e.stringInt)
            is PasswordException -> setPasswordError(e.stringInt)
        }
    }

    fun setUsername(username: String) {
        _emailOrUsernameState.value = _emailOrUsernameState.value.copy(
            text = username
        )
    }

    fun setPassword(password: String) {
        _passwordState.value = _passwordState.value.copy(
            text = password
        )
    }

    fun setPasswordVisibility(isVisible: Boolean) {
        _passwordState.value = _passwordState.value.copy(
            showPassword = isVisible
        )
    }

    private fun setEmailOrUsernameError(stringInt: Int) {
        if (_emailOrUsernameState.value.stringInt != stringInt) {
            _emailOrUsernameState.value = _emailOrUsernameState.value.copy(
                stringInt = stringInt
            )
        }
    }

    private fun setPasswordError(stringInt: Int) {
        if (_passwordState.value.stringInt != stringInt) {
            _passwordState.value = _passwordState.value.copy(
                stringInt = stringInt
            )
        }
    }
}