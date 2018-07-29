package com.pimp.pimplib.callback

import com.pimp.pimplib.model.AuctionHouseStatus

interface AHStatusCallback {
    fun onSuccess( auctionHouseStatus: AuctionHouseStatus)
    fun onFailed(throwable: Throwable)
}