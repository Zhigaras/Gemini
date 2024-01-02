package com.zhigaras.chat.data

import com.zhigaras.ai.Ai
import com.zhigaras.ai.ResponseWrapper
import com.zhigaras.chat.domain.ChatRepository

class ChatRepositoryImpl(private val ai: Ai) : ChatRepository {
    override suspend fun sendPrompt(prompt: String): ResponseWrapper {
        return ai.generateText(prompt)
    }
}