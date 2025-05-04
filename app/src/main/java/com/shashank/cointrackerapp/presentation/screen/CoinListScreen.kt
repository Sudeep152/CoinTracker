package com.shashank.cointrackerapp.presentation.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.shashank.cointrackerapp.presentation.composable.CoinItem
import com.shashank.cointrackerapp.presentation.model.toCoinUI
import com.shashank.cointrackerapp.presentation.viewmodel.CoinViewModel

@Composable
fun CoinListScreen(modifier: Modifier = Modifier, viewModel: CoinViewModel = hiltViewModel()) {
    val coinListState by viewModel.coinListState.collectAsState()
    val loadingState by viewModel.loadingState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.callGetCoinList()
    }
    if (loadingState) {
        CircularProgressIndicator()
    } else {
        LazyColumn {
            items(coinListState.data.size) {
                CoinItem(coin = coinListState.data[it].toCoinUI())
            }
        }
    }
}


