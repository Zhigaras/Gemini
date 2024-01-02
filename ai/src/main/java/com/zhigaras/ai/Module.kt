package com.zhigaras.ai

import com.google.ai.client.generativeai.GenerativeModel
import org.koin.dsl.bind
import org.koin.dsl.module

fun aiModule() = module {
    
    single { GenerativeModel("gemini-pro", BuildConfig.GEMINI_KEY) }
    
    factory { GeminiAi(get()) } bind Ai::class
}