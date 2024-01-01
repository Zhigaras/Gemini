package com.zhigaras.ai

interface Ai {
    
    suspend fun generateContent(prompt: String): String
}