package com.example.homework2

import android.app.Application
import com.example.homework2.di.appModule
import com.example.homework2.di.featureModule
import com.example.homework2.di.filmsModule
import com.example.homework2.di.networkModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidContext(this@App)
            modules(
                appModule,
                featureModule,
                networkModule,
                filmsModule
            )
        }
    }
}
