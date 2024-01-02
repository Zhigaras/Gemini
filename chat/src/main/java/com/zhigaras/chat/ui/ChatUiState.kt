package com.zhigaras.chat.ui

import com.zhigaras.chat.ui.model.AbstractMessage
import com.zhigaras.core.UiState

data class ChatUiState(
    val messages: List<AbstractMessage> = emptyList(),
    val inputText: String = ""
) : UiState