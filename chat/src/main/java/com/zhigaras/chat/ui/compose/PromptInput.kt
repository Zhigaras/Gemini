package com.zhigaras.chat.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zhigaras.chat.R

@Composable
fun PromptInput(
    text: String,
    onTextChanged: (String) -> Unit,
    onSendClick: () -> Unit
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = onTextChanged,
        placeholder = {
            Text(text = stringResource(id = R.string.prompt_placeholder))
        },
        trailingIcon = {
            if (text.isNotBlank())
                Image(
                    modifier = Modifier
                        .size(30.dp)
                        .clickable(onClick = onSendClick),
                    imageVector = Icons.Filled.Send,
                    contentDescription = stringResource(id = R.string.send)
                )
        }
    )
}