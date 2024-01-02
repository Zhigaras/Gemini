package com.zhigaras.chat.ui.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class IncomingMessage(override val text: String) : AbstractMessage() {
    override val type = MessageType.INCOMING
    override val backgroundColor = Color.Magenta
}

@Preview
@Composable
fun IncomingMessagePreview() {
    IncomingMessage("asdqweasd").Show()
}