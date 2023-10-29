package com.buzzbites.instaconadmin.di

import com.buzzbites.instaconadmin.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

}