package com.zhigaras.ai

interface Ai {
    
    suspend fun generateText(prompt: String): ResponseWrapper
}