package com.rehan.junoandroidassignment.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rehan.junoandroidassignment.repositories.EmptyStateRepository
import com.rehan.junoandroidassignment.repositories.ValueStateRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ValueStateViewModel @Inject constructor(private val valueStateRepository: ValueStateRepository) : ViewModel() {

    val cryptoBalanceLiveData get() = valueStateRepository.cryptoBalanceLiveData
    val cryptoHoldingsLiveData get() = valueStateRepository.cryptoHoldingsLiveData
    val cryptoPricesLiveData get() = valueStateRepository.cryptoPricesLiveData
    val cryptoAllTransactionsLiveData get() = valueStateRepository.cryptoAllTransactionsLiveData

    fun getValueCryptoBalance() {
        viewModelScope.launch {
            valueStateRepository.getValueCryptoBalance()
        }
    }

    fun getValueCryptoHoldings() {
        viewModelScope.launch {
            valueStateRepository.getValueCryptoHoldings()
        }
    }

    fun getValueCryptoPrices() {
        viewModelScope.launch {
            valueStateRepository.getValueCryptoPrices()
        }
    }

    fun getValueCryptoAllTransactions() {
        viewModelScope.launch {
            valueStateRepository.getValueCryptoAllTransactions()
        }
    }
}