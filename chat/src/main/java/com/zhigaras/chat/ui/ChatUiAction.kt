package com.zhigaras.chat.ui

import com.zhigaras.core.FlowWrapper
import com.zhigaras.core.UiAction

interface ChatUiAction : UiAction<FlowWrapper<ChatUiState>> {
    
    class PromptInputChanged(private val newPrompt: String) : ChatUiAction {
        override fun handle(flowWrapper: FlowWrapper<ChatUiState>) {
            flowWrapper.update {
                it.copy(inputText = newPrompt)
            }
        }
    }
}