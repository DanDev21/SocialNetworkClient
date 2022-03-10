package com.dan.socialnetwork.feature_auth.presentation.signup

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dan.socialnetwork.R
import com.dan.socialnetwork.core.domain.state.StandardTextFieldState
import com.dan.socialnetwork.feature_auth.data.dto.SignupForm
import com.dan.socialnetwork.feature_auth.data.validation.SignupException
import com.dan.socialnetwork.feature_auth.data.validation.SignupException.*
import com.dan.socialnetwork.feature_auth.use_case.SignupUseCase
import com.dan.socialnetwork.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val signupUseCase: SignupUseCase,
) : ViewModel() {

    private val _emailState = mutableStateOf(StandardTextFieldState())
    val emailState: State<StandardTextFieldState> = _emailState

    private val _usernameState = mutableStateOf(StandardTextFieldState())
    val usernameState: State<StandardTextFieldState> = _usernameState

    private val _passwordState = mutableStateOf(StandardTextFieldState())
    val passwordState: State<StandardTextFieldState> = _passwordState

    private val _passwordConfirmationState = mutableStateOf(StandardTextFieldState())
    val passwordConfirmationState: State<StandardTextFieldState> = _passwordConfirmationState

    private val _showPasswordState = mutableStateOf(false)
    val showPasswordState: State<Boolean> = _showPasswordState

    private val _signingUpState = mutableStateOf(false)
    val signingUpState: State<Boolean> = _signingUpState

    private val _signupResultFlow = MutableSharedFlow<Result<Unit>>(replay = 1)
    val signupResultFlow = _signupResultFlow.asSharedFlow()

    fun signup() = viewModelScope.launch {
        try {
            resetStatesErrors()
            _signingUpState.value = true

            _signupResultFlow.emit(
                signupUseCase(
                    SignupForm(
                        email = emailState.value.text.trim(),
                        username = usernameState.value.text.trim(),
                        password = passwordState.value.text.trim(),
                        passwordConfirmation = passwordConfirmationState.value.text.trim(),
                    )
                )
            )
        } catch (e: SignupException) {
            handleUserInputException(e)
        } finally {
            _signingUpState.value = false
        }
    }

    private fun resetStatesErrors() {
        setErrorTo(
            R.string.empty,
            _emailState,
            _usernameState,
            _passwordState,
            _passwordConfirmationState
        )
    }

    private fun handleUserInputException(e: SignupException) {
        when (e) {
            is UsernameException -> {
                setErrorTo(e.stringInt, _usernameState)
            }
            is EmailException -> {
                setErrorTo(e.stringInt, _emailState)
            }
            is PasswordException -> {
                setErrorTo(e.stringInt, _passwordState, _passwordConfirmationState)
            }
        }
    }

    private fun setErrorTo(
        stringInt: Int,
        vararg states: MutableState<StandardTextFieldState>,
    ) {
        states.forEach {
            if (it.value.stringInt != stringInt) {
                it.value = it.value.copy(stringInt = stringInt)
            }
        }
    }

    fun setEmail(value: String) {
        _emailState.value = _emailState.value.copy(
            text = value
        )
    }

    fun setUsername(value: String) {
        _usernameState.value = _usernameState.value.copy(
            text = value
        )
    }

    fun setPassword(value: String) {
        _passwordState.value = _passwordState.value.copy(
            text = value
        )
    }

    fun setPasswordConfirmation(value: String) {
        _passwordConfirmationState.value = _passwordConfirmationState.value.copy(
            text = value
        )
    }

    fun setPasswordVisibility(isVisible: Boolean) {
        _showPasswordState.value = isVisible
    }
}