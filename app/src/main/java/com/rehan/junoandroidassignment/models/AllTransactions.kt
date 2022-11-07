package com.rehan.junoandroidassignment.models

import com.google.gson.annotations.SerializedName

data class AllTransactions(
    @SerializedName("txn_logo")
    val txn_logo: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("txn_time")
    val txn_time: String,
    @SerializedName("txn_amount")
    val txn_amount: String,
    @SerializedName("txn_sub_amount")
    val txn_sub_amount: String
)