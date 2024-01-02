package com.zhigaras.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

interface FlowWrapper<T : Any> {
    
    fun post(item: T)
    
    fun update(func: (T) -> T)
    
    @Composable
    fun collectAsState(): State<T>
    
    abstract class Abstract<T : Any>(initial: T) : FlowWrapper<T> {
        
        private val flow = MutableStateFlow(initial)
        
        override fun post(item: T) {
            flow.value = item
        }
        
        override fun update(func: (T) -> T) {
            flow.update(func)
        }
        
        @Composable
        override fun collectAsState() = flow.collectAsState()
    }
}