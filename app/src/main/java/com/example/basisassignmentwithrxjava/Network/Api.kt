package com.example.basisassignmentwithrxjava.Network


import com.example.basisassignmentwithrxjava.Model.Data
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET


interface Api {

    @GET("anishbajpai014/d482191cb4fff429333c5ec64b38c197/raw/b11f56c3177a9ddc6649288c80a004e7df41e3b9/HiringTask.json")
    fun getAllFoodList(): Observable<List<Data>>
}