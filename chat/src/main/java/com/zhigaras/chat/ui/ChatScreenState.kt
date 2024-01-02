package com.zhigaras.chat.ui

import com.zhigaras.chat.ui.model.AbstractMessage

class ChatScreenState(
    private val messages: List<AbstractMessage> = emptyList(),
    private val inputText: String = ""
)