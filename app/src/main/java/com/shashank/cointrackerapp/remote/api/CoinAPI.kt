package com.shashank.cointrackerapp.remote.api

import com.shashank.cointrackerapp.remote.model.response.CoinListResponse
import retrofit2.http.GET

interface CoinAPI {
    @GET("v2/assets")
    suspend fun getCoinList(): CoinListResponse
}