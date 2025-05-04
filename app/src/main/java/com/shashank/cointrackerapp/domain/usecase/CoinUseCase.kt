package com.shashank.cointrackerapp.domain.usecase

import com.shashank.cointrackerapp.domain.model.repository.CoinRepository
import javax.inject.Inject

class CoinUseCase @Inject constructor(private val repository: CoinRepository) {
    suspend operator fun invoke() = repository.getCoinList()
}