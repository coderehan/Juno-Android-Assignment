package com.rehan.junoandroidassignment.models

import com.google.gson.annotations.SerializedName

data class CryptoPrices(
    @SerializedName("logo")
    val logo: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("current_price_in_usd")
    val current_price_in_usd: String
)