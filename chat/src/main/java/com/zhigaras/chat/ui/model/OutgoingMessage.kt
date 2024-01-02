package com.zhigaras.chat.ui.model

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class OutgoingMessage(override val text: String): AbstractMessage() {
    @Composable
    override fun Show() {
        Box(contentAlignment = Alignment.CenterEnd) {
            Text(
                modifier = Modifier.background(Color.Magenta),
                text = text)
        }
    }
}