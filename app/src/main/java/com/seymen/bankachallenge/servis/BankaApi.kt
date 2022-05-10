package com.seymen.bankachallenge.servis

import com.seymen.bankachallenge.model.SubeBilgileriModel
import io.reactivex.Single
import retrofit2.http.GET

interface BankaApi {

    // https://raw.githubusercontent.com/ fatiha380/mockjson/main/bankdata
    @GET("fatiha380/mockjson/main/bankdata")
    fun getBilgiler() : Single<List<SubeBilgileriModel>>
}