package com.example.recyclerwithglide

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface APIService {
    @GET( "photos")
    fun getPhotos(@Query("client_id") key: String = APIManager.key1)  : Call<List<Photo>>
}