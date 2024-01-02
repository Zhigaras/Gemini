package com.zhigaras.chat.domain

import kotlin.coroutines.cancellation.CancellationException

interface ChatInteractor {
    
    suspend fun sendPrompt(prompt: String): GeneratingResult
    
    class Base(private val repository: ChatRepository) : ChatInteractor {
        override suspend fun sendPrompt(prompt: String): GeneratingResult {
            return try {
                GeneratingResult.Success(repository.sendPrompt(prompt))
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                GeneratingResult.Error(e.message ?: "")
            }
        }
    }
}