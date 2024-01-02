package com.zhigaras.chat.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zhigaras.chat.ui.model.IncomingMessage
import com.zhigaras.chat.ui.model.OutgoingMessage
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChatScreen(viewModel: ChatViewModel = koinViewModel()) {
    Column {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(listOf(IncomingMessage("asd"), OutgoingMessage("qwe"))) {
                it.Show()
            }
        }
    }
}