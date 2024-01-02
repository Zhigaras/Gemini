package com.zhigaras.ai

import com.google.ai.client.generativeai.GenerativeModel

class GeminiAi(private val ai: GenerativeModel) : Ai {
    
    override suspend fun generateText(prompt: String): ResponseWrapper {
        return ResponseWrapper(ai.generateContent(prompt))
    }
}