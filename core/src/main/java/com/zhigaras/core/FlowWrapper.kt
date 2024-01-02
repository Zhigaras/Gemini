package com.zhigaras.core

import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow

interface FlowWrapper<T : Any> {
    
    fun post(item: T)
    
    suspend fun collect(collector: FlowCollector<T>)
    
    abstract class Abstract<T : Any>(initial: T) : FlowWrapper<T> {
        
        private val flow = MutableStateFlow(initial)
        
        override fun post(item: T) {
            flow.value = item
        }
        
        override suspend fun collect(collector: FlowCollector<T>) {
            flow.collect(collector)
        }
    }
}