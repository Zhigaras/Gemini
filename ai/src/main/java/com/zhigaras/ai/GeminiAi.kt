package com.zhigaras.ai

import com.google.ai.client.generativeai.GenerativeModel

class GeminiAi : Ai {
    
    private val ai = GenerativeModel("gemini-pro", BuildConfig.GEMINI_KEY)
    
    override suspend fun generateContent(prompt: String): String {
        return ai.generateContent(prompt).text ?: "sorrrrry"
    }
}