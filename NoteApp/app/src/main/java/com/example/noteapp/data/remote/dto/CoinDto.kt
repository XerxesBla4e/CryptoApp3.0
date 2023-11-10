package com.example.noteapp.data.remote.dto

import com.example.noteapp.domain.model.Coin
import com.google.gson.annotations.SerializedName

data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val is_Active: Boolean,
    @SerializedName("is_new")
    val is_New: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

//function to convert coindto to normal coin without some fields
fun CoinDto.toCoin(): Coin {
return Coin(
    id = id,
    is_Active = is_Active,
    name = name,
    rank = rank,
    symbol = symbol
)
}


