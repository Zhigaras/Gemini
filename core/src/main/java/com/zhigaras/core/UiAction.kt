package com.zhigaras.core

interface UiAction<T : FlowWrapper<*>> {
    
    fun handle(flowWrapper: T)
}