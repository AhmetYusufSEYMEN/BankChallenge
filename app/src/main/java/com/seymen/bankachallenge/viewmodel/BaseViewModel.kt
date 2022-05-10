package com.seymen.bankachallenge.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.seymen.bankachallenge.model.SubeBilgileriModel
import com.seymen.bankachallenge.servis.BankaApiServis
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class BaseViewModel(application: Application) : AndroidViewModel(application) {
    val subeler = MutableLiveData<List<SubeBilgileriModel>>()
    val hataMesaji = MutableLiveData<Boolean>()
    val yukleniyormuPB = MutableLiveData<Boolean>()

    private val bankaApiServis = BankaApiServis()
    private val disposable = CompositeDisposable()

    fun getDataVM(){
        yukleniyormuPB.value = true

        disposable.add(bankaApiServis.getData().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<SubeBilgileriModel>>(){
                override fun onSuccess(t: List<SubeBilgileriModel>) {
                    subeler.value = t
                    hataMesaji.value = false
                    yukleniyormuPB.value = false
                }

                override fun onError(e: Throwable) {
                hataMesaji.value = true
                yukleniyormuPB.value = false
                    e.printStackTrace()
                }
            }))
    }
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return  networkInfo != null && networkInfo.isConnected
    }
}