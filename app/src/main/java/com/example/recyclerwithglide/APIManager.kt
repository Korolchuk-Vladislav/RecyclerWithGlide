package com.example.recyclerwithglide

import retrofit2.Callback

object APIManager {
    val key1 = "OwV53ktQW-pW1gM55fB9Vs6g-Mb7sIUPZGpJqVc5nLo"
    fun getPhotos(callBack:Callback<List<Photo>>){
        App.instance!!.retrofit.create(APIService::class.java)
            .getPhotos()
            .enqueue(callBack)

    }
}