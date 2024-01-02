package com.zhigaras.chat.ui.model

import androidx.compose.runtime.Composable

abstract class AbstractMessage {
    
    abstract val text: String
    
    @Composable
    abstract fun Show()
}