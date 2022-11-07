package com.rehan.junoandroidassignment.models

import com.google.gson.annotations.SerializedName

data class CryptoHoldings(
    @SerializedName("logo")
    val logo: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("current_bal_in_token")
    val current_bal_in_token: String,
    @SerializedName("current_bal_in_usd")
    val current_bal_in_usd: String
)