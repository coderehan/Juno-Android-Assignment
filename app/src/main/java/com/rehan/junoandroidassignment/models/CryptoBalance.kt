package com.rehan.junoandroidassignment.models

import com.google.gson.annotations.SerializedName

data class CryptoBalance(
    @SerializedName("title")
    val title: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("current_bal_in_usd")
    val current_bal_in_usd: String,
    @SerializedName("your_crypto_holdings")
    val your_crypto_holdings: CryptoHoldings,
    @SerializedName("crypto_prices")
    val crypto_prices: CryptoPrices,
    @SerializedName("all_transactions")
    val all_transactions: AllTransactions
)