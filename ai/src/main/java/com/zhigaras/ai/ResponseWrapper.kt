package com.zhigaras.ai

import com.google.ai.client.generativeai.type.GenerateContentResponse

class ResponseWrapper(private val response: GenerateContentResponse) {
    
    fun candidates() = response.candidates
    
    fun text() = response.text ?: "Sorry..." // TODO: replace with string res
}