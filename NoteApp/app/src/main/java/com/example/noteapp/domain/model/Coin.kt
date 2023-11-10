package com.example.noteapp.domain.model

import com.google.gson.annotations.SerializedName

data class Coin(
    val id: String,
    val is_Active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)
