package com.zhigaras.gemini

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zhigaras.ai.GeminiAi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val ai = GeminiAi()
    val state = MutableStateFlow("...")
    
    fun generate() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = ai.generateText("Say Hello in ten random languages")
            state.value = response.text()
        }
    }
}