package com.zhigaras.chat.ui.model

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

abstract class AbstractMessage {
    
    abstract val text: String
    abstract val type: MessageType
    abstract val backgroundColor: Color
    
    @Composable
    fun Show() {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = if (type == MessageType.INCOMING) Alignment.CenterStart else Alignment.CenterEnd
        ) {
            Box(
                modifier = Modifier.background(
                    color = backgroundColor,
                    shape = ShapeDefaults.Medium
                )
            ) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = text
                )
            }
        }
    }
}