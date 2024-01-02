package com.zhigaras.chat.ui

import com.zhigaras.chat.ui.model.AbstractMessage
import com.zhigaras.core.UiState

class ChatUiState(
    private val messages: List<AbstractMessage> = emptyList(),
    private val inputText: String = ""
) : UiState