package com.seymen.bankachallenge.servis


import com.seymen.bankachallenge.model.SubeBilgileriModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class BankaApiServis {

    private val BASE_URL = "https://raw.githubusercontent.com/"
    private val api= Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(BankaApi::class.java)

    fun getData() : Single<List<SubeBilgileriModel>>{
    return api.getBilgiler()
    }
}