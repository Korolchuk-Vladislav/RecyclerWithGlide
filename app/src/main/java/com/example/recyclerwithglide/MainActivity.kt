package com.example.recyclerwithglide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<List<Photo>> {
    val adapter1 = MyAdapter(listOf())
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.adapter = adapter1
        APIManager.getPhotos(this)
        list.layoutManager = LinearLayoutManager(this)
        list.hasFixedSize()
    }

    override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
Toast.makeText(this,"Error occurred", Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
   if(response.isSuccessful) {
       if (!response.body().isNullOrEmpty()) {
         adapter1.setPhotos(response.body()!!)
       }
   }else{
       Toast.makeText(this, "Error occurred", Toast.LENGTH_SHORT).show()
       }
    }
}