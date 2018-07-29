package com.pimp.pimplib.api.service

import com.pimp.pimplib.api.response.Result
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface AHSService{
    @GET("wow/auction/data/ysondre")
    fun getWSAHYsondreData(@Query("apiKey") apiKey : String, @Query("locale") locale : String): Single<Result>

}