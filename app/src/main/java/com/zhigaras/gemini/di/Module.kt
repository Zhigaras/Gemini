package com.zhigaras.gemini.di

import com.zhigaras.core.Dispatchers
import org.koin.dsl.bind
import org.koin.dsl.module

fun mainModule() = module {
    
    factory { Dispatchers.Base() } bind Dispatchers::class
}