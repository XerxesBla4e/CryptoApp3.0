package com.example.noteapp.di

import com.example.noteapp.common.Constants
import com.example.noteapp.data.remote.CoinPaprikaApi
import com.example.noteapp.data.repository.CoinRepositoryImpl
import com.example.noteapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)//all dependencies live aslong as the application does
object AppModule {

    @Provides
    @Singleton//single instance of this across the whole app
    fun providePaprikaApi() : CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL
            ).addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun providesCoinRepository(api: CoinPaprikaApi):CoinRepository{
        return CoinRepositoryImpl(api)
    }
}