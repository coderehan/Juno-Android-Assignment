package com.rehan.junoandroidassignment.api

import com.rehan.junoandroidassignment.models.AllTransactions
import com.rehan.junoandroidassignment.models.CryptoBalance
import com.rehan.junoandroidassignment.models.CryptoHoldings
import com.rehan.junoandroidassignment.models.CryptoPrices
import retrofit2.Response
import retrofit2.http.GET

interface CryptoAPI {

    @GET("empty-home")
    suspend fun getEmptyCryptoBalance(): Response<CryptoBalance>

    @GET("empty-home")
    suspend fun getEmptyCryptoHoldings(): Response<List<CryptoHoldings>>

    @GET("empty-home")
    suspend fun getEmptyCryptoPrices(): Response<List<CryptoPrices>>

    @GET("empty-home")
    suspend fun getEmptyCryptoAllTransactions(): Response<List<AllTransactions>>

    @GET("home")
    suspend fun getValueCryptoBalance(): Response<CryptoBalance>

    @GET("home")
    suspend fun getValueCryptoHoldings(): Response<List<CryptoHoldings>>

    @GET("home")
    suspend fun getValueCryptoPrices(): Response<List<CryptoPrices>>

    @GET("home")
    suspend fun getValueCryptoAllTransactions(): Response<List<AllTransactions>>

}