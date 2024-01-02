package com.zhigaras.chat.ui

import com.zhigaras.core.FlowWrapper
import com.zhigaras.core.UiAction

interface ChatUiAction : UiAction<FlowWrapper<ChatUiState>> {
    
    class PromptInputChanged(newPrompt: String) : ChatUiAction {
        override fun handle(flowWrapper: FlowWrapper<ChatUiState>) {
            TODO("Not yet implemented")
        }
        
    }
}