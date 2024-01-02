package com.zhigaras.gemini

import android.app.Application
import com.zhigaras.chat.di.chatModule
import com.zhigaras.gemini.di.mainModule
import org.koin.core.context.startKoin

class App : Application() {
    
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(mainModule() + chatModule())
        }
    }
}