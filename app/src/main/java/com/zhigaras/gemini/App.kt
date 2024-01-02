package com.zhigaras.gemini

import android.app.Application
import com.zhigaras.chat.di.chatModule
import org.koin.core.context.startKoin

class App : Application() {
    
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(chatModule())
        }
    }
}