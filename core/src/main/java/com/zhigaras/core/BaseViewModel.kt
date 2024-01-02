package com.zhigaras.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.FlowCollector

abstract class BaseViewModel<S : UiState, A : UiAction<FlowWrapper<S>>>(
    private val dispatchers: Dispatchers
) : ViewModel() {
    
    protected abstract val uiFlowWrapper: FlowWrapper<S>
    
    suspend fun observe(collector: FlowCollector<S>) = uiFlowWrapper.collect(collector)
    
    fun handleAction(action: A){
        action.handle(uiFlowWrapper)
    }
}