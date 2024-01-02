package com.zhigaras.chat.domain

import com.zhigaras.ai.ResponseWrapper

interface ChatRepository {
    
    suspend fun sendPrompt(prompt: String): ResponseWrapper
}