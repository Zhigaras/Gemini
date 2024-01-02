package com.zhigaras.chat.domain

import com.zhigaras.chat.ui.ChatUiState
import com.zhigaras.core.FlowWrapper

interface ChatFlowWrapper : FlowWrapper<ChatUiState> {
    
    class Base : FlowWrapper.Abstract<ChatUiState>(ChatUiState()), ChatFlowWrapper
}