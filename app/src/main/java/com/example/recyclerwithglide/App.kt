package com.example.recyclerwithglide

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class App : Application() {
     lateinit var retrofit: Retrofit

    companion object{
        var instance:App? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.unsplash.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}