package com.shashank.cointrackerapp.data.mapper

import com.shashank.cointrackerapp.domain.model.Coin
import com.shashank.cointrackerapp.domain.model.ListOfCoin
import com.shashank.cointrackerapp.remote.model.response.CoinDataResponse
import com.shashank.cointrackerapp.remote.model.response.CoinListResponse


fun CoinListResponse.toCoinList(): ListOfCoin {
    return ListOfCoin(
        data = data?.mapNotNull { it?.toCoin() } ?: emptyList(),
        timestamp = timestamp ?: 0
    )
}

fun CoinDataResponse.toCoin(): Coin? {
    val id = id ?: return null
    val rank = rank?.toIntOrNull() ?: return null
    val name = name ?: return null
    val symbol = symbol ?: return null
    val marketCapUsd = marketCapUsd?.toDoubleOrNull() ?: return null
    val priceUsd = priceUsd?.toDoubleOrNull() ?: return null
    val changePercent24Hr = changePercent24Hr?.toDoubleOrNull() ?: return null
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr
    )
}