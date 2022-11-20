package org.mdeveloperz.coffeebeen.android.presentation.bases

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.mdeveloperz.mobile.common.domain.bases.BaseUseCase

interface ViewState

sealed interface LoadingState {
    object IDL: LoadingState
    object Loading: LoadingState
    data class Success(val messages: List<String> = emptyList()): LoadingState
    data class Error(val messages: List<String> = emptyList()): LoadingState
}

abstract class BaseViewModel<VIEW_STATE: ViewState>: ViewModel() {
    private val _uiViewState by lazy { MutableStateFlow(initializeState()) }
    val viewState: StateFlow<VIEW_STATE> = _uiViewState.asStateFlow()

    protected abstract fun initializeState(): VIEW_STATE

    protected fun <REQUEST, RESULT> execute(
        input: REQUEST,
        useCase: BaseUseCase<REQUEST, RESULT>,
        onResult: (RESULT) -> Unit,
        onError: (Exception) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val response = useCase.execute(input)
                onResult(response)
            } catch (exception: Exception) {
                onError(exception)
            }
        }
    }

    protected fun updateState(function: (prevState: VIEW_STATE) -> VIEW_STATE) {
        _uiViewState.update(function)
    }
}