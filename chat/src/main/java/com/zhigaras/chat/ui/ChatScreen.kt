package com.zhigaras.chat.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.zhigaras.chat.ui.model.IncomingMessage
import com.zhigaras.chat.ui.model.OutgoingMessage

@Composable
fun ChatScreen() {
    Column {
        LazyColumn{
            items(listOf(IncomingMessage("asd"), OutgoingMessage("qwe"))){
                it.Show()
            }
        }
        
    }
}