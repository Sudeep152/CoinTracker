package com.shashank.cointrackerapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ListOfCoin(
    val data: List<Coin>,
    val timestamp: Long
)

@Serializable
data class Coin(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val marketCapUsd: Double,
    val priceUsd: Double,
    val changePercent24Hr: Double,
)