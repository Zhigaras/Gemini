package com.zhigaras.chat.domain

interface ChatInteractor {
    
    class Base(private val repository: ChatRepository) : ChatInteractor
}