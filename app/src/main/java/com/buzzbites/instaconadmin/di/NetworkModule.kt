package com.buzzbites.instaconadmin.di

import com.buzzbites.instaconadmin.retrofit.RetrofitAPI
import com.buzzbites.instaconadmin.utils.Constant
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesRetrofitAPI(retrofit: Retrofit): RetrofitAPI {
        return  retrofit.create(RetrofitAPI::class.java)
    }
}