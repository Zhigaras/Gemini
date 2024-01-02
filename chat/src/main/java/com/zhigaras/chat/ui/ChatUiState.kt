package com.zhigaras.chat.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zhigaras.chat.ui.compose.PromptInput
import com.zhigaras.chat.ui.model.AbstractMessage
import com.zhigaras.core.UiState

data class ChatUiState(
    val messages: List<AbstractMessage> = emptyList(),
    val inputText: String = ""
) : UiState {
    
    @Composable
    fun Show(
        onTextChanged: (String) -> Unit,
        onSendClick: () -> Unit
    ) {
        Column {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                reverseLayout = true,
                verticalArrangement = Arrangement.spacedBy(10.dp),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(messages) {
                    it.Show()
                }
            }
            PromptInput(text = inputText, onTextChanged = onTextChanged, onSendClick = onSendClick)
        }
    }
}