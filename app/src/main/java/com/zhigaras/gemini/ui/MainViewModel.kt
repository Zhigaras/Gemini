package com.zhigaras.gemini.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.zhigaras.gemini.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    
    private val ai = GenerativeModel("gemini-pro", BuildConfig.GEMINI_KEY)
    val state = MutableStateFlow("...")
    
    fun generate() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = ai.generateContent("Say Hello in ten random languages")
            state.value = response.text ?: "sorry"
        }
    }
}