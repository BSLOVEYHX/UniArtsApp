package com.zysc.uniartsapp.base

import android.app.Application
import com.zysc.uniartsapp.di.allModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 *@Date:2021/6/1
 *@Author:Created by peter_ben
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(allModule)
        }
    }
}