package com.rehan.junoandroidassignment.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rehan.junoandroidassignment.repositories.EmptyStateRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmptyStateViewModel @Inject constructor(private val emptyStateRepository: EmptyStateRepository) : ViewModel() {

    val cryptoBalanceLiveData get() = emptyStateRepository.cryptoBalanceLiveData
    val cryptoHoldingsLiveData get() = emptyStateRepository.cryptoHoldingsLiveData
    val cryptoPricesLiveData get() = emptyStateRepository.cryptoPricesLiveData
    val cryptoAllTransactionsLiveData get() = emptyStateRepository.cryptoAllTransactionsLiveData

    fun getEmptyCryptoBalance() {
        viewModelScope.launch {
            emptyStateRepository.getEmptyCryptoBalance()
        }
    }

    fun getEmptyCryptoHoldings() {
        viewModelScope.launch {
            emptyStateRepository.getEmptyCryptoHoldings()
        }
    }

    fun getEmptyCryptoPrices() {
        viewModelScope.launch {
            emptyStateRepository.getEmptyCryptoPrices()
        }
    }

    fun getEmptyCryptoAllTransactions() {
        viewModelScope.launch {
            emptyStateRepository.getEmptyCryptoAllTransactions()
        }
    }
}