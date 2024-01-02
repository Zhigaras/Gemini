package com.zhigaras.chat.ui

interface ChatScreenAction {
    
    fun handle(state: ChatScreenState)
    
    class PromptInputChanged(newPrompt: String) : ChatScreenAction {
        
        override fun handle(state: ChatScreenState) {
        
        }
    }
}