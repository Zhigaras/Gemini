package com.zhigaras.chat.ui.model

import androidx.compose.ui.graphics.Color

class OutgoingMessage(override val text: String) : AbstractMessage() {
    override val type = MessageType.OUTGOING
    override val backgroundColor = Color.Cyan
}