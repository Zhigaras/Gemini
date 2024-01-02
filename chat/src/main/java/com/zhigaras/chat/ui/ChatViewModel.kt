package com.zhigaras.chat.ui

import androidx.lifecycle.ViewModel
import com.zhigaras.chat.domain.ChatInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ChatViewModel(private val interactor: ChatInteractor) : ViewModel() {
    
    private val _state = MutableStateFlow(ChatScreenState())
    val state = _state.asStateFlow()
    
    
}