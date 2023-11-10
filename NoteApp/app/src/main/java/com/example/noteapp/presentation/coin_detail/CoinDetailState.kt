package com.example.noteapp.presentation.coin_detail

import com.example.noteapp.domain.model.Coin
import com.example.noteapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
