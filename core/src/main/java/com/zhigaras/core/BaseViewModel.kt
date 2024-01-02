package com.zhigaras.core

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel<S : UiState, A : UiAction<FlowWrapper<S>>>(
    private val dispatchers: Dispatchers
) : ViewModel() {
    
    protected abstract val uiFlowWrapper: FlowWrapper<S>
    
    @Composable
    fun collectUiState() = uiFlowWrapper.collectAsState()
    
    fun handleAction(action: A) {
        action.handle(uiFlowWrapper)
    }
    
    protected fun <E> scopeLaunch(
        onBackground: suspend () -> E,
        onUi: suspend (E) -> Unit
    ) = viewModelScope.launch(dispatchers.io()) {
        val result = onBackground.invoke()
        withContext(dispatchers.main()) {
            onUi.invoke(result)
        }
    }
}