package com.zhigaras.chat.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zhigaras.chat.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChatScreen(viewModel: ChatViewModel = koinViewModel()) {
    val state by viewModel.collectUiState()
    Column {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            reverseLayout = true,
            verticalArrangement = Arrangement.Bottom
        ) {
            items(state.messages) {
                it.Show()
            }
        }
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.inputText,
            onValueChange = { viewModel.handleAction(ChatUiAction.PromptInputChanged(it)) },
            placeholder = {
                Text(text = stringResource(id = R.string.prompt_placeholder))
            },
            trailingIcon = {
                if (state.inputText.isNotBlank())
                    Image(
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { viewModel.send() },
                        imageVector = Icons.Filled.Send,
                        contentDescription = stringResource(id = R.string.send)
                    )
            }
        )
    }
}