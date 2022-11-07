package com.rehan.junoandroidassignment.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rehan.junoandroidassignment.api.CryptoAPI
import com.rehan.junoandroidassignment.models.AllTransactions
import com.rehan.junoandroidassignment.models.CryptoBalance
import com.rehan.junoandroidassignment.models.CryptoHoldings
import com.rehan.junoandroidassignment.models.CryptoPrices
import javax.inject.Inject

class ValueStateRepository @Inject constructor(private val cryptoAPI: CryptoAPI) {

    // MutableLiveData
    private val _cryptoBalanceLiveData = MutableLiveData<CryptoBalance>()
    private val _cryptoHoldingsLiveData = MutableLiveData<List<CryptoHoldings>>()
    private val _cryptoPricesLiveData = MutableLiveData<List<CryptoPrices>>()
    private val _cryptoAllTransactionsLiveData = MutableLiveData<List<AllTransactions>>()

    // Public Read only LiveData
    val cryptoBalanceLiveData: LiveData<CryptoBalance>
        get() = _cryptoBalanceLiveData

    val cryptoHoldingsLiveData: LiveData<List<CryptoHoldings>>
        get() = _cryptoHoldingsLiveData

    val cryptoPricesLiveData: LiveData<List<CryptoPrices>>
        get() = _cryptoPricesLiveData

    val cryptoAllTransactionsLiveData: LiveData<List<AllTransactions>>
        get() = _cryptoAllTransactionsLiveData

    suspend fun getValueCryptoBalance() {
        val response = cryptoAPI.getValueCryptoBalance()
        if (response.isSuccessful && response.body() != null) {
            _cryptoBalanceLiveData.postValue(response.body())
        } else {
            return
        }
    }

    suspend fun getValueCryptoHoldings() {
        val response = cryptoAPI.getValueCryptoHoldings()
        if (response.isSuccessful && response.body() != null) {
            _cryptoHoldingsLiveData.postValue(response.body())
        } else {
            return
        }
    }

    suspend fun getValueCryptoPrices() {
        val response = cryptoAPI.getValueCryptoPrices()
        if (response.isSuccessful && response.body() != null) {
            _cryptoPricesLiveData.postValue(response.body())
        } else {
            return
        }
    }

    suspend fun getValueCryptoAllTransactions() {
        val response = cryptoAPI.getValueCryptoAllTransactions()
        if (response.isSuccessful && response.body() != null) {
            _cryptoAllTransactionsLiveData.postValue(response.body())
        } else {
            return
        }
    }

}