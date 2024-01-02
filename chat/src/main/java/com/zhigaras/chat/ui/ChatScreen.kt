package com.zhigaras.chat.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.zhigaras.chat.ui.model.IncomingMessage
import com.zhigaras.chat.ui.model.OutgoingMessage
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChatScreen(viewModel: ChatViewModel = koinViewModel()) {
    val state by viewModel.collectUiState()
    Column {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(listOf(IncomingMessage("asd"), OutgoingMessage("qwe"))) {
                it.Show()
            }
        }
        TextField(
            value = state.inputText,
            onValueChange = { viewModel.handleAction(ChatUiAction.PromptInputChanged(it)) })
    }
}