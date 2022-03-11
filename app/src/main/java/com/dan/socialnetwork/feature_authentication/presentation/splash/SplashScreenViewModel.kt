package com.dan.socialnetwork.feature_authentication.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dan.socialnetwork.feature_authentication.domain.AuthenticationUseCase
import com.dan.socialnetwork.core.data.dto.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val authenticationUseCase: AuthenticationUseCase
) : ViewModel() {

    private val _authenticationResultFlow = MutableSharedFlow<Result<Unit>>()
    val authenticationResultFlow = _authenticationResultFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            _authenticationResultFlow.emit(authenticationUseCase())
        }
    }
}