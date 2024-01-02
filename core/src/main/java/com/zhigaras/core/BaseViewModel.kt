package com.zhigaras.core

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<S : UiState, A : UiAction<FlowWrapper<S>>>(
    private val dispatchers: Dispatchers
) : ViewModel() {
    
    protected abstract val uiFlowWrapper: FlowWrapper<S>
    
    @Composable
    fun collectUiState() = uiFlowWrapper.collectAsState()
    
    fun handleAction(action: A) {
        action.handle(uiFlowWrapper)
    }
}