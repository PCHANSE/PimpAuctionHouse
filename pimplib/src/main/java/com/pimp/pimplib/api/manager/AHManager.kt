package com.pimp.pimplib.api.manager

import com.pimp.pimplib.api.service.AHSService
import com.pimp.pimplib.callback.AHStatusCallback
import com.pimp.pimplib.model.AuctionHouseStatus
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AHManager() {

    fun create(): AHSService {
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://eu.api.battle.net/")
                .build().create(AHSService::class.java)
        return retrofit
    }


    fun getAHYsondreData(aAHStatusCallback: AHStatusCallback) {
        create().getWSAHYsondreData("dpmq98zc44n66w8wdeedz8eyuwxnftu3", "fr_FR")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { success ->
                            val resultAHStatus = AuctionHouseStatus(success.files.get(0).url, success.files.get(0).lastModified)
                            aAHStatusCallback.onSuccess(resultAHStatus)
                        },
                        { error ->
                            aAHStatusCallback.onFailed(error)
                        }
                )
    }
}

