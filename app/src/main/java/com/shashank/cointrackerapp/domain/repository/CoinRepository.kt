package com.shashank.cointrackerapp.domain.model.repository

import com.shashank.cointrackerapp.domain.model.Coin
import com.shashank.cointrackerapp.domain.model.ListOfCoin
import com.shashank.cointrackerapp.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

interface CoinRepository {
    suspend fun getCoinList(): NetworkResult<Flow<ListOfCoin>>
}