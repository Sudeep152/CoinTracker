package com.shashank.cointrackerapp.data.repository

import com.shashank.cointrackerapp.data.mapper.toCoinList
import com.shashank.cointrackerapp.domain.model.ListOfCoin
import com.shashank.cointrackerapp.domain.model.repository.CoinRepository
import com.shashank.cointrackerapp.remote.api.CoinAPI
import com.shashank.cointrackerapp.utils.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(val api: CoinAPI) : CoinRepository {

    override suspend fun getCoinList(): NetworkResult<Flow<ListOfCoin>> {
        return try {
            NetworkResult.Loading
            val coinListFlow = flow {
                val coinList = api.getCoinList().toCoinList()
                emit(coinList)
            }
            NetworkResult.Success(coinListFlow)
        } catch (e: Exception) {
            NetworkResult.Error(e.message)
        }
    }
}