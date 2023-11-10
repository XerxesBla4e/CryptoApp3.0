package com.example.noteapp.domain.use_cases.get_coin

import android.net.http.HttpException
import android.os.Build
import android.os.ext.SdkExtensions
import com.example.noteapp.common.Resource
import com.example.noteapp.data.remote.dto.toCoin
import com.example.noteapp.data.remote.dto.toCoinDetail
import com.example.noteapp.domain.model.Coin
import com.example.noteapp.domain.model.CoinDetail
import com.example.noteapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && SdkExtensions.getExtensionVersion(
                Build.VERSION_CODES.S
            ) >= 7
        ) {
            try {
                emit(Resource.Loading())
                val coin = repository.getCoinById(coinId).toCoinDetail()
                emit(Resource.Success(coin))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage?:"An unexpected error occured"))
            } catch (e: IOException) {
                emit(Resource.Error("Couldn't reach server! Check" +
                        "your internet connection"))
            }
        }
    }
}