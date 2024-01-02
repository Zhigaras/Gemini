package com.zhigaras.chat.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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
        Row(
            modifier = Modifier
                .wrapContentHeight(Alignment.CenterVertically)
                .height(IntrinsicSize.Max)
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                value = state.inputText,
                onValueChange = { viewModel.handleAction(ChatUiAction.PromptInputChanged(it)) },
                placeholder = {
                    Text(text = stringResource(id = R.string.prompt_placeholder))
                },
            )
            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp)
                    .clickable { viewModel.send() },
                contentScale = ContentScale.FillHeight,
                imageVector = Icons.Filled.Send,
                contentDescription = stringResource(id = R.string.send)
            )
        }
    }
}