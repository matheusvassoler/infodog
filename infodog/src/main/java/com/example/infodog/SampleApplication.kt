package com.example.infodog

import android.app.Application
import com.example.infodog.di.infoDogModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SampleApplication)
            modules(infoDogModule)
        }
    }
}