package com.zysc.uniartsapp.base;

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.zysc.uniartsapp.BuildConfig
import com.zysc.uniartsapp.di.netModule
import com.zysc.uniartsapp.di.repositoryModule
import com.zysc.uniartsapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class UniArtApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@UniArtApplication)
            modules(listOf(netModule, repositoryModule, viewModelModule))
        }

        // 初始化 Logger 日志打印
        val strategy = PrettyFormatStrategy.newBuilder()
            .tag("SAMPLE")
            .build()
        Logger.addLogAdapter(object : AndroidLogAdapter(strategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }
}
