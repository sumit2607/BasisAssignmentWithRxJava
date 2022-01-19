package com.example.basisassignmentwithrxjava.Network

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit

class Retrofit {

    companion object{
       private val retrofit=Retrofit.Builder()
            .baseUrl(Url.baseUrl)
            .addConverterFactory(CustomConverterFactory())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        val api: Api = retrofit.create(Api::class.java)
    }
}