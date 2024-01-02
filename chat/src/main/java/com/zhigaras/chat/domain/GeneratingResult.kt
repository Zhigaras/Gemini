package com.zhigaras.chat.domain

import com.zhigaras.ai.ResponseWrapper
import com.zhigaras.chat.ui.model.IncomingMessage

interface GeneratingResult {
    
    fun handle(flowWrapper: ChatFlowWrapper)
    
    class Success(private val response: ResponseWrapper) : GeneratingResult {
        override fun handle(flowWrapper: ChatFlowWrapper) {
            flowWrapper.update { it.copy(messages = mutableListOf(IncomingMessage(response.text())) + it.messages) }
        }
    }
    
    class Error(private val message: String) : GeneratingResult {
        override fun handle(flowWrapper: ChatFlowWrapper) {
            // TODO: handle errors
        }
    }
}