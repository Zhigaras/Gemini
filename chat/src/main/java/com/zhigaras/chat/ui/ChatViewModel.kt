package com.zhigaras.chat.ui

import com.zhigaras.chat.domain.ChatFlowWrapper
import com.zhigaras.chat.domain.ChatInteractor
import com.zhigaras.core.BaseViewModel
import com.zhigaras.core.Dispatchers

class ChatViewModel(
    dispatchers: Dispatchers,
    override val uiFlowWrapper: ChatFlowWrapper,
    private val interactor: ChatInteractor
) : BaseViewModel<ChatUiState, ChatUiAction>(dispatchers) {

}