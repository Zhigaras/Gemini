package com.zhigaras.chat.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChatScreen(viewModel: ChatViewModel = koinViewModel()) {
    val state by viewModel.collectUiState()
    
    state.Show(
        onTextChanged = { viewModel.handleAction(ChatUiAction.PromptInputChanged(it)) },
        onSendClick = { viewModel.send() }
    )
}