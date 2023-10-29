package com.buzzbites.instaconadmin

import android.app.Application
import com.buzzbites.instaconadmin.di.ApplicationComponent
import com.buzzbites.instaconadmin.di.DaggerApplicationComponent

class MyApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}