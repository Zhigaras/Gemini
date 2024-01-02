package com.zhigaras.ai

import com.google.ai.client.generativeai.GenerativeModel

class GeminiAi : Ai {
    
    private val ai = GenerativeModel("gemini-pro", BuildConfig.GEMINI_KEY)
    
    override suspend fun generateText(prompt: String): ResponseWrapper {
        return ResponseWrapper(ai.generateContent(prompt))
    }
}