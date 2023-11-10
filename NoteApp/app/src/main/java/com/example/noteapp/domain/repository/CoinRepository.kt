package com.example.noteapp.domain.repository

import com.example.noteapp.data.remote.dto.CoinDetailDto
import com.example.noteapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}