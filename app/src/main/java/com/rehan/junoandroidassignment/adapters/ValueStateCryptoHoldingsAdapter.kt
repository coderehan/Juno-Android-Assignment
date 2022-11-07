package com.rehan.junoandroidassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rehan.junoandroidassignment.databinding.AdapterEmptyStateCryptoHoldingsBinding
import com.rehan.junoandroidassignment.databinding.AdapterValueStateCryptoHoldingsBinding
import com.rehan.junoandroidassignment.models.CryptoHoldings

class ValueStateCryptoHoldingsAdapter : RecyclerView.Adapter<ValueStateCryptoHoldingsAdapter.ViewHolder>() {

    private var valueStateCryptoHoldings = ArrayList<CryptoHoldings>()

    fun setValueStateCryptoHoldings(valueStateCryptoHoldings : List<CryptoHoldings>){
        this.valueStateCryptoHoldings = valueStateCryptoHoldings as ArrayList<CryptoHoldings>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterValueStateCryptoHoldingsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(valueStateCryptoHoldings[position].logo)
            .into(holder.binding.ivLogo)

        holder.binding.tvTitle.text = valueStateCryptoHoldings[position].title
        holder.binding.tvCurrentBalanceToken.text = valueStateCryptoHoldings[position].current_bal_in_token
        holder.binding.tvCurrentBalanceUsd.text = valueStateCryptoHoldings[position].current_bal_in_usd
    }

    override fun getItemCount(): Int {
        return valueStateCryptoHoldings.size
    }

    inner class ViewHolder(val binding: AdapterValueStateCryptoHoldingsBinding) : RecyclerView.ViewHolder(binding.root)

}