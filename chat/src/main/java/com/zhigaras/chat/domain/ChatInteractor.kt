package com.zhigaras.chat.domain

interface ChatInteractor {
    
    class Base(repository: ChatRepository) : ChatInteractor
}