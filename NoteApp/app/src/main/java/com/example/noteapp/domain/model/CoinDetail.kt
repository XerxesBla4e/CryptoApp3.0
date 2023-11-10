package com.example.noteapp.domain.model

import com.example.noteapp.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description:String,
    val symbol:String,
    val rank:Int,
    val is_active:Boolean,
    val tags:List<String>,
    val team:List<TeamMember>
)
