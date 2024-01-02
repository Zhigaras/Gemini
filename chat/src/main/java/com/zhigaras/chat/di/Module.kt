package com.zhigaras.chat.di

import com.zhigaras.ai.aiModule
import com.zhigaras.chat.data.ChatRepositoryImpl
import com.zhigaras.chat.domain.ChatInteractor
import com.zhigaras.chat.domain.ChatRepository
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.zhigaras.chat.ui.ChatViewModel
import org.koin.dsl.bind

fun chatModule() = aiModule() + module {
    
    viewModelOf(::ChatViewModel)
    
    factory { ChatInteractor.Base(get()) } bind ChatInteractor::class
    
    factory { ChatRepositoryImpl(get()) } bind ChatRepository::class
}